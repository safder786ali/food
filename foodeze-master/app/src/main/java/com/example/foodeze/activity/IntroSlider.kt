package com.example.foodeze.activity

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.foodeze.R
import com.example.lanecrowd.Session_Package.SessionManager
import kotlinx.android.synthetic.main.activity_intro_slider.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class IntroSlider : AppCompatActivity(), KodeinAware {
    private lateinit var layouts: IntArray
    private var viewPager: ViewPager? = null
    private val session: SessionManager by instance()
    override val kodein by kodein()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_intro_slider)




        radioGroup.check(radioGroup.getChildAt(0).id)

        viewPager = findViewById(R.id.view_pager)

           layouts= intArrayOf(
                R.layout.intro_1,
                R.layout.intro_2,
                R.layout.intro_3
            )





        val myViewPagerAdapter = MyViewPagerAdapter()
        viewPager!!.adapter = myViewPagerAdapter
        viewPager!!.setOnPageChangeListener(viewPagerPageChangeListener)



        getStarted.setOnClickListener {


               startActivity(Intent(applicationContext, LoginFront::class.java))

        }

    }


    var viewPagerPageChangeListener: OnPageChangeListener = object : OnPageChangeListener {
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun onPageSelected(position: Int) { // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.size - 1) {

                getStarted.visibility=View.VISIBLE
            }
            else
                getStarted.visibility=View.GONE

            radioGroup.check(radioGroup.getChildAt(position).id)

        }

        override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {}
        override fun onPageScrollStateChanged(arg0: Int) {}
    }


    inner class MyViewPagerAdapter internal constructor() : PagerAdapter() {
        private var layoutInflater: LayoutInflater? = null
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = layoutInflater!!.inflate(layouts[position], container, false)
            container.addView(view)
            return view
        }

        override fun getCount(): Int {
            return layouts.size
        }


        override fun getItemPosition(`object`: Any): Int {
            return super.getItemPosition(`object`)
        }

        override fun isViewFromObject(view: View, obj: Any): Boolean {
            return view === obj
        }

        override fun destroyItem(
            container: ViewGroup,
            position: Int,
            `object`: Any
        ) {
            val view = `object` as View
            container.removeView(view)
        }
    }
}