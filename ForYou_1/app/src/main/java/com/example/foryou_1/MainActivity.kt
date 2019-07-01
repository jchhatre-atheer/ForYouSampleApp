package com.example.foryou_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

   // private val viewModel: ForYouViewModel by viewModels()
   private lateinit var viewModel: ForYouViewModel
    private var forYouModel: ForYouModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*******************************last working code**********************************/
        viewModel = ViewModelProviders.of(this).get(ForYouViewModel::class.java)


       /* clickMeButton.setOnClickListener{
            Log.d("activity", "button clicked")
            viewModel.callApi()
        }


        viewModel.forYouModelLiveData.observe(this, Observer {result->textView.text = result?.data?.welcome_message
            if(result?.data != null)
               // viewModel.insert(result?.data)
            forYouModel = result?.data
        })
        */

        /*  val  viewPager = findViewById<ViewPager>(R.id.viewPager)

          viewPager.adapter = viewModel.getDummyViewPagerAdapter(supportFragmentManager)


          viewModel.forYouModelLiveData.observe(this, Observer {//validate this!!!!!!!!!!!!!!!!!!!
              viewPager.adapter = viewModel.getViewPagerAdapter(supportFragmentManager)
          })
          */

        val  viewPager = findViewById<ViewPager>(R.id.viewPager)

        viewPager.adapter = viewModel.getViewPagerAdapter(supportFragmentManager)


        viewModel.forYouModelLiveData.observe(this, Observer {//validate this!!!!!!!!!!!!!!!!!!!
            viewPager.adapter = viewModel.getViewPagerAdapter(supportFragmentManager)
        })
    }
}
