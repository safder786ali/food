package com.example.foodeze.util

import com.example.lanecrowd.retrofit.ApiInterface
import com.example.lanecrowd.util.NetworkConnectionInterceptor
import com.example.lanecrowd.util.URLC
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class testclass{

  companion object {
    operator fun invoke(networkConnectionInterceptor: NetworkConnectionInterceptor) {

        val retrofit: Retrofit? = null
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(networkConnectionInterceptor)
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()


        if (retrofit == null) {

            //  http://rentlagao.com/debt/login
              Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(URLC.Base_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

                .build()
            retrofit!!.create(ApiInterface::class.java)


        }




    }


}
}
