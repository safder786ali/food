package com.example.foodeze.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.foodeze.R
import com.example.foodeze.databinding.ActivitySplashBinding
import com.example.lanecrowd.Session_Package.SessionManager
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class SplashActivity : AppCompatActivity(), KodeinAware {
    private var SPLASH_DISPLAY_LENGHT: Long = 3000
    private val session: SessionManager by instance()
    override val kodein by kodein()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        var activityBinding =
            DataBindingUtil.setContentView<ActivitySplashBinding>(this, R.layout.activity_splash)


        if (session.isLoggedIn) {

            Handler().postDelayed({
                session.checkLogin()
            }, SPLASH_DISPLAY_LENGHT)


        } else {
            Handler().postDelayed({
               // val intent = Intent(this@SplashActivity, IntroSlider::class.java)
               // val intent = Intent(this@SplashActivity, MenuItem::class.java)
                val intent = Intent(this@SplashActivity, HomeActivity::class.java)
              // val intent = Intent(this@SplashActivity, CreateEvent::class.java)
                startActivity(intent)
                finish()
            }, SPLASH_DISPLAY_LENGHT)

            val myanim2 = AnimationUtils.loadAnimation(this, R.anim.mysplashanimation)
            activityBinding.logo.startAnimation(myanim2)

        }
    }
}
