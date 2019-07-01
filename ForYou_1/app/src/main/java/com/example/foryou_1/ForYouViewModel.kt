package com.example.foryou_1

import android.app.Application
import android.util.Log
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.example.github.vo.Resource
import com.example.foryou_1.api.ForYouWebService
import com.example.foryou_1.dummyviewpager.DummyViewPagerAdapter
import com.example.foryou_1.db.AssignmentModelX
import com.example.samplearchitectureforyou.ContentModel
import com.example.samplearchitectureforyou.db.ContentModelTypeConverter
import com.example.samplearchitectureforyou.db.ForYouDatabase
import com.example.samplearchitectureforyou.db.ForYouRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jetbrains.annotations.NotNull

class ForYouViewModel(application: Application): AndroidViewModel(application) {

    var forYouModelLiveData: LiveData<Resource<ForYouModel>>
    val repository: ForYouRepository
    val owner: String = "admin"

    init{
        val dao = ForYouDatabase.getDatabase(application, viewModelScope).forYouDao()
        repository = ForYouRepository(dao, ForYouWebService.getForYouWebService())
      //  forYouModel = repository.getForYouModel()
        Log.d("viewModel", "in init method")
        forYouModelLiveData = repository.loadForYouModel(owner)
       // forYouModelLiveData = repository.loadForYouModel(owner)
    }

    fun callApi(){
        Log.d("vm", "api called")
        forYouModelLiveData = repository.loadForYouModel(owner)
    }

   /* fun insert(forYouModel: ForYouModel) = viewModelScope.launch(Dispatchers.IO) {
        Log.d("viewModel", "inside insert")
        repository.insert(forYouModel)
    }*/


    //for ForYouModel
    fun getViewPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter? {

        Log.d("vm", "inside getViewPagerAdapter method")

        var viewPagerList: ArrayList<ContentModel> = ArrayList<ContentModel>()

        @NotNull
        var res: Resource<ForYouModel>? = forYouModelLiveData.value
        var forYouModel: ForYouModel? = res?.data

        if(forYouModel != null){

            Log.d("vmif", "for you model not null")

            //*************************populate ContentModel list- viewPagerList**********************
            //questions count
            var questions: List<AssignmentModelX> = forYouModel.questions
            if(questions != null && questions.size > 0){
                    Log.d("ques count", "inside ques count")
                    questions.get(0).`object`?.count = forYouModel.questions_count.toString()
                    viewPagerList.add(questions.get(0).`object`)
                }
            else
                Log.d("else of ques", "ques list is null")



            //commenting for now, till one of the fields "object" is resolved in AssignmentModel
            //announcements
            var announcements: List<AssignmentModelX> = forYouModel.announcements
            if(announcements != null && announcements.size > 0){
                Log.d("announcements", "inside announcements")
                for (item in announcements)
                    viewPagerList.add(item.`object`)
            }

            //public announcements
            var publicAnnouncements: List<ContentModel> = forYouModel.public_announcements
            if(publicAnnouncements != null && publicAnnouncements.size > 0){
                Log.d("pub announcements", "inside pub announcements")
                for(item in publicAnnouncements)
                    viewPagerList.add(item)
            }

            //did you know
            var didYouKnow: ContentModel? = forYouModel.did_you_know
            if(didYouKnow != null) {
                Log.d("didYouKnow", "inside didYouKnow")
                viewPagerList.add(didYouKnow)
            }

            //*************************populate AssignmentModel list- questionList**********************

            var questionsList: ArrayList<AssignmentModelX> = ArrayList<AssignmentModelX>()
            if(questions != null && questions.size > 0){
                Log.d("questionsList", "inside questionsList")
                for(item in questions)
                    questionsList.add(item)
            }

            val adapter: ForYouViewPagerAdapter = ForYouViewPagerAdapter(fm, forYouModel.questions_count, viewPagerList, questionsList)
            return  adapter
        }
        return null //what should be returned here
    }



    fun getDummyViewPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter?{

        return DummyViewPagerAdapter(fm)
    }

}