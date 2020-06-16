package com.example.foodeze.util


import android.content.Context
import com.example.lanecrowd.retrofit.ApiInterface
import com.example.lanecrowd.util.AppController
import com.example.lanecrowd.util.NetworkConnectionInterceptor
import com.example.lanecrowd.util.URLC
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.newSingleThreadContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitClient {
    private val BASE_URL = URLC.Base_URL
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
                .method(original.method(), original.body())
            val request = requestBuilder.build()
            chain.proceed(request)
        }

        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .build()
    val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .client(okHttpClient)
            .build()

        retrofit.create(Api::class.java)
    }
   /* val instanced: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .client(okHttpClient)
            .build()̥

        retrofit.create(Api::class.java)
    }*/
}
