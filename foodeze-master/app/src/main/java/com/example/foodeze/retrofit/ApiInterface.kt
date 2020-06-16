package com.example.lanecrowd.retrofit


import com.example.foodeze.model.HomeCatModelApi
import com.example.lanecrowd.util.NetworkConnectionInterceptor
import com.example.lanecrowd.util.URLC
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import java.util.concurrent.TimeUnit


interface ApiInterface {


    //role 1-client
    //2-trainer


    companion object {
        fun invoke(networkConnectionInterceptor: NetworkConnectionInterceptor):ApiInterface {

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
                    return Retrofit.Builder()
                        .client(okHttpClient)
                        .baseUrl(URLC.Base_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

                        .build()
                        .create(ApiInterface::class.java)


                }

                return retrofit.create(ApiInterface::class.java)


        }


    }

    //for Login
    @FormUrlEncoded
    @POST("signup")
    suspend fun registrationAPi(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("role") role: String
    ): JsonObject




    @POST("get-all-product-categories")
    suspend fun HomeCatAPi():HomeCatModelApi

}
