package com.example.samplearchitectureforyou.db

import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.android.example.github.vo.Resource
import com.example.foryou_1.util.AppExecutors
import com.example.foryou_1.ForYouModel
import com.example.foryou_1.NetworkBoundResource
import com.example.foryou_1.api.ForYouWebService
import com.example.foryou_1.extraclasses.RateLimiter
import java.util.concurrent.TimeUnit


class ForYouRepository(private val dao: ForYouDao, private val forYouWebService: ForYouWebService) {

    private val rateLimit = RateLimiter<String>(3, TimeUnit.MINUTES)
    val token: String = "Bearer ath-eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYWljIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTU2MTg0NzcwNX0.OGR4q5VL5A34txxy0npjWDiHBv86KJC9oYQet2cdhTgAO1hKfCtqAA9FaIwM8rEie2mWzaq2Tt5lkF5gApIozQ"
    private val appExecutors: AppExecutors =
        AppExecutors() //dicey instantiation


   /* fun getForYouModel(): LiveData<ForYouModel>{
        val data = MutableLiveData<ForYouModel>()

       // val token: String = "Bearer ath-eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX1VTRVIiLCJleHAiOjE1NjE0MjU5MjF9.7CW8-T8gscj7FB5wlyuC6Ssb4j00pB-sI6oSz7mjHzuyxoHmk2jKnL_IGQjFPphgUQ7d2eCVaHf-xztISuPoLA"
        forYouWebService.getForYouModel(token).enqueue(
            object : Callback<ForYouModel>{

                override fun onResponse(call: Call<ForYouModel>, response: Response<ForYouModel>) {
                    data.value = response.body()
                }

                // Error case is left out for brevity.
                override fun onFailure(call: Call<ForYouModel>, t: Throwable) {

                }

            }
        )
        return data
    }*/

    fun loadForYouModel(owner: String): LiveData<Resource<ForYouModel>> {
        Log.d("repo", "in loadForYouModel method")
        val uid: String = "58d03973fbc2791da41c1a00"
        return object : NetworkBoundResource<ForYouModel, ForYouModel>(appExecutors) {
            override fun saveCallResult(item: ForYouModel) {
                item.uid = uid
                dao.insert(item)
            }

            override fun shouldFetch(data: ForYouModel?): Boolean {
                Log.d("repo", "in shouldFetch method, data: " + data?.uid)

                return data == null || rateLimit.shouldFetch(owner)
            }

            override fun loadFromDb(): LiveData<ForYouModel> {
                Log.d("repo", "in loadFromDb method")
                return dao.loadForYouModelFromDb(uid)//dicey
            }

            override fun createCall() = forYouWebService.getForYouModel(token)

            override fun onFetchFailed() {
                rateLimit.reset(owner)
            }
        }.asLiveData()
    }

    /*
    @WorkerThread
    suspend fun insert(forYouModel: ForYouModel) {
        Log.d("repo", "in insert function")

        dao.insert(forYouModel)
    }*/
}