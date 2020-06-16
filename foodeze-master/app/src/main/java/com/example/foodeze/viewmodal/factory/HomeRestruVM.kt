package com.example.foodeze.viewmodal.factory

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodeze.model.HomeCatModelApi
import com.example.foodeze.model.HomeItemProductModelApi
import com.example.foodeze.model.RespMsgModelApi
import com.example.foodeze.util.Api
import com.example.foodeze.util.RetrofitClient
import com.example.lanecrowd.modal.repository.UserRepository
import com.example.lanecrowd.retrofit.ApiInterface
import com.example.lanecrowd.util.AppController
import com.example.lanecrowd.util.Coroutines
import com.example.lanecrowd.util.NetworkConnectionInterceptor

import io.reactivex.internal.operators.maybe.MaybeToPublisher.instance
import kotlinx.coroutines.newSingleThreadContext
import org.kodein.di.android.subKodein
import org.kodein.di.generic.instance

class HomeRestruVM():ViewModel() {
    var HomeRestuRes: MutableLiveData<HomeCatModelApi>? = null
    var HomeProddate: MutableLiveData<HomeItemProductModelApi>? = null
    var HomeProdlikedate: MutableLiveData<RespMsgModelApi>? = null
    lateinit var api: Api
    lateinit var repo : UserRepository

    fun HomeRestu(): MutableLiveData<HomeCatModelApi> {

        api = RetrofitClient.instance.apply {  }

        repo =UserRepository(api)

        HomeRestuRes = MutableLiveData()
        HomeCatAPi()
        return HomeRestuRes as MutableLiveData<HomeCatModelApi>

    }
    fun HomeProduct(): MutableLiveData<HomeItemProductModelApi> {

        api = RetrofitClient.instance.apply {  }

        repo =UserRepository(api)

        HomeProddate = MutableLiveData()
        HomeProdAPi()
        return HomeProddate as MutableLiveData<HomeItemProductModelApi>

    }
    fun HomeProdlike(user_id:String,
                     product_id:String,
                     like:String): MutableLiveData<RespMsgModelApi> {

        api = RetrofitClient.instance.apply {  }

        repo =UserRepository(api)

        HomeProdlikedate = MutableLiveData()
        HomeProdlikeAPi(user_id,product_id,like)
        return HomeProdlikedate as MutableLiveData<RespMsgModelApi>

    }
    fun HomeCatAPi() {
        Coroutines.main {
            try {
                val response = repo.HomeCatRespoAPi()
                HomeRestuRes!!.value = response

            } catch (e: Exception) {
                e.printStackTrace()
                HomeRestuRes?.value = null
            }
        }

    }
    fun HomeProdAPi() {
        Coroutines.main {
            try {
                val response = repo.HomeProductRespoAPi()
                HomeProddate!!.value = response

            } catch (e: Exception) {
                e.printStackTrace()
                HomeProddate?.value = null
            }
        }

    }
    fun HomeProdlikeAPi(user_id:String,
                        product_id:String,
                        like:String) {
        Coroutines.main {
            try {
                val response = repo.HomeProductLikeRespoAPi(user_id,product_id,like)
                HomeProdlikedate!!.value = response

            } catch (e: Exception) {
                e.printStackTrace()
                HomeProdlikedate?.value = null
            }
        }

    }
}