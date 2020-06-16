package com.example.lanecrowd.modal.repository

import com.example.foodeze.model.HomeCatModelApi
import com.example.foodeze.model.HomeItemProductModelApi
import com.example.foodeze.model.OrderModelApiCall
import com.example.foodeze.model.RespMsgModelApi
import com.example.foodeze.util.Api
import com.example.lanecrowd.retrofit.ApiInterface
import com.google.gson.JsonObject

class UserRepository(val api:Api) {
    suspend fun HomeCatRespoAPi(): HomeCatModelApi {
        return api.HomeCatAPi()
    }

    suspend fun HomeProductRespoAPi(): HomeItemProductModelApi {
        return api.HomeProdAPi()
    }
    suspend fun HomeProductLikeRespoAPi(user_id:String,
                                        product_id:String,
                                        like:String): RespMsgModelApi {
        return api.HomeProdlikeAPi(user_id,product_id,like)
    }
    suspend fun OrderRespAPi(user_id:String,
                                        product_id:String): JsonObject {
        return api.OrderAPi(user_id,product_id)
    }






}