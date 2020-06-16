package com.example.foodeze.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.foodeze.R
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_login_front.*
import java.util.concurrent.TimeUnit

class LoginFront : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_front)
        setListener()
    }


    private fun setListener() {


        val observable1 = RxView.clicks(facebook!!).map { o -> facebook!! }
        val observable2 = RxView.clicks(google!!).map { o -> google!! }
        val observable3 = RxView.clicks(phone!!).map { o -> phone }
        val observable4 = RxView.clicks(gmail).map { o -> gmail }



        Observable.merge(observable1, observable2, observable3, observable4).throttleFirst(2, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread()).subscribe { o ->

                if (o == facebook || o == google || o == phone || o == gmail)

                    startActivity(Intent(applicationContext, HomeActivity::class.java))


            }

    }
}
