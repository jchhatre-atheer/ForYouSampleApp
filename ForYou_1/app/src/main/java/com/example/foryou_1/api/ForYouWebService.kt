package com.example.foryou_1.api

import android.util.Log
import androidx.lifecycle.LiveData
import com.android.example.github.util.LiveDataCallAdapterFactory
import com.example.foryou_1.ForYouModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

interface ForYouWebService {

    @GET("api/users/me/foryou") //create constants, avoid hardcoding
    fun getForYouModel(@Header("Authorization")authToken: String): LiveData<ApiResponse<ForYouModel>>

    companion object{ //singleton pattern
        fun getForYouWebService(): ForYouWebService{
            val retrofit = Retrofit.Builder()
                /*.addCallAdapterFactory(
                    RxJava2CallAdapterFactory.create())*/
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .addConverterFactory(
                    GsonConverterFactory.create())
                .baseUrl("https://demo.atheer.dev/") //create constants, avoid hardcoding
                .build()

            Log.d("url", "url is "+retrofit.create(ForYouWebService::class.java).toString())
            return retrofit.create(ForYouWebService::class.java)
        }
    }
}