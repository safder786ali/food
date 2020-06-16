package com.example.foodeze.model

import java.io.Serializable

class HomeCatModelApi(val code:Int,val data:ArrayList<getData>):Serializable {


     class getData(val id:Int,
                   val category_title:String,
                   val image:String):Serializable{

     }

}