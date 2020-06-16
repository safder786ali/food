package com.example.foodeze.viewmodal.factory

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodeze.model.HomeCatModelApi
import com.example.foodeze.model.HomeItemProductModelApi
import com.example.foodeze.model.OrderModelApiCall
import com.example.foodeze.model.RespMsgModelApi
import com.example.foodeze.util.Api
import com.example.foodeze.util.RetrofitClient
import com.example.lanecrowd.modal.repository.UserRepository
import com.example.lanecrowd.util.Coroutines
import com.google.gson.JsonObject

class OrderVM :ViewModel(){
    var Orderrdata: MutableLiveData<JsonObject>? = null

    lateinit var api: Api
    lateinit var repo : UserRepository

    fun Order(user_id:String,
              product_id:String): MutableLiveData<JsonObject> {

        api = RetrofitClient.instance.apply {  }

        repo =UserRepository(api)

        Orderrdata = MutableLiveData()
        OrderAPi(user_id,product_id)
        return Orderrdata as MutableLiveData<JsonObject>

    }
    fun OrderAPi(user_id:String,
                 product_id:String) {
        Coroutines.main {
            try {
                val response = repo.OrderRespAPi(user_id,product_id)
                Orderrdata!!.value = response

            } catch (e: Exception) {
                e.printStackTrace()
                Orderrdata?.value = null
            }
        }

    }

}