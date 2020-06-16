package com.example.foodeze.model

import java.io.Serializable

class HomeItemProductModelApi(val code:Int,val data:ArrayList<getData>): Serializable {


    class getData(val id:Int,
                  val product_title:String,
                  val restaurent_name:String,
                  val product_price:String,
                  val product_discount:String,
                  val image:String,
                  val best_seller:String,
                  val likes:String
                  ): Serializable {

    }

}