package com.example.foryou_1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.example.foryou_1.db.AssignmentModelX
import com.example.foryou_1.util.DidYouKnowFragment
import com.example.samplearchitectureforyou.ContentModel
import kotlinx.android.synthetic.main.fragment_questions.*

class ForYouViewPagerAdapter(fm: FragmentManager,questionsCount:Int?,
                             viewPagerList: ArrayList<ContentModel>,
                             questionList: ArrayList<AssignmentModelX>): FragmentStatePagerAdapter(fm) {

    private  var contentModelList: ArrayList<ContentModel> = viewPagerList
    private  var assignmentModelList: ArrayList<AssignmentModelX> = questionList
    private var count: Int? = questionsCount

  /*  public fun ForYouViewPagerAdapter(questionsCount:Int, viewPagerList: ArrayList<ContentModel>, questionList: ArrayList<AssignmentModel>){
        contentModelList = viewPagerList
        assignmentModelList = questionList
        count = questionsCount
    }*/

    override fun getCount(): Int {
        return contentModelList.size
    }


    override fun getItem(position: Int): Fragment {

        val viewPagerFragment = ForYouViewPagerFragment()//fragment containing image view
        val questionsFragment = QuestionsFragment()
        val didYouKnowFragment = DidYouKnowFragment()
        val publicAnnouncementsFragment = PublicAnnouncementsFragment()
        Log.d("vpadapter", "size of list: "+contentModelList.size)

        val bundle = Bundle()

        if(contentModelList.get(position).data.type.contains("question")){

            bundle.putString("questionText", "${assignmentModelList.size} Left")
            bundle.putParcelableArrayList("assignmentModelList", assignmentModelList)
            questionsFragment.arguments = bundle
            //button on click listener pending


            return questionsFragment
        }


        if(contentModelList.get(position).data.type.contains("did_you_know")){

            val mediaId = contentModelList.get(position).media_id
            Log.d("vpadapter", "in didyouKnow media id: "+mediaId)
            Log.d("vpadapter", ""+ contentModelList.get(position).data.content)

            bundle.putString("description", contentModelList.get(position).data.content)
            bundle.putString("title", contentModelList.get(position).title)
            bundle.putString("titleColor", contentModelList.get(position).data.title_color)
            bundle.putString("imageUrl", "https://demo.atheer.dev/media/images/${mediaId}")

            didYouKnowFragment.arguments = bundle

            return didYouKnowFragment

        }

        if(contentModelList.get(position).data.type.contains("announcement")) {

            val mediaId = contentModelList.get(position).media_id

            Log.d("vpadapter", "media id: " + mediaId)

            if (contentModelList.get(position).data.is_public) {


                bundle.putString("description", contentModelList.get(position).data.content)
                bundle.putString("descriptionColor", contentModelList.get(position).data.content_color)
                bundle.putString("title", contentModelList.get(position).title)
                bundle.putString("titleColor", contentModelList.get(position).data.title_color)
                if(mediaId != null)
                    bundle.putString("imageUrl", "https://demo.atheer.dev/media/images/${mediaId}")
                else
                    bundle.putString("imageUrl", "")
                publicAnnouncementsFragment.arguments = bundle

            }
            if (!contentModelList.get(position).data.is_public) {

                bundle.putString("imageUrl", "https://demo.atheer.dev/media/images/${mediaId}")
                viewPagerFragment.arguments = bundle
                return viewPagerFragment
            }
        }
        return publicAnnouncementsFragment
    }
}