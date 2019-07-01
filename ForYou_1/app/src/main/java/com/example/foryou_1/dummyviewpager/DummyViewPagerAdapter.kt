package com.example.foryou_1.dummyviewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.samplearchitectureforyou.AssignmentModel
import com.example.samplearchitectureforyou.ContentModel

class DummyViewPagerAdapter(fm: FragmentManager/*, questionsCount:Int?,
                            viewPagerList: ArrayList<ContentModel>,
                            questionList: ArrayList<AssignmentModel>*/): FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int {
        return 5
    }

    override fun getItem(position: Int): Fragment {

        val viewPagerFragment = DummyViewPagerFragment()
        val bundle = Bundle()
        var url: String = ""

        if(position == 0){
            url = "https://barkpost.com/wp-content/uploads/2016/07/13423558_1262167337140652_61291435_n.jpg"
        }

        if(position == 1){
            url = "https://i.barkpost.com/wp-content/uploads/2019/06/shih-tzu-smiling.jpg"
        }

        if(position == 2){
            url = "https://barkpost.com/wp-content/uploads/2019/06/shih-tzu-in-pajamas.jpg"
        }

        if(position == 3){
            url = "https://i.barkpost.com/wp-content/uploads/2015/09/dog-flower-crown-2.jpg"
        }

        if(position == 4){
            url = "https://i.barkpost.com/wp-content/uploads/2016/06/cava-poo-chon.jpg"
        }

        bundle.putString("imageUrl", url)
        viewPagerFragment.arguments = bundle
        return  viewPagerFragment
    }
}