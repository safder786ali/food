package com.example.foodeze.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "HistoryProdut")
class HistoryProdut  constructor (prod_id:String,prod_baner:String,prod_titel:String,
                                  prod_rest:String,prod_qunty:String,prod_total:String){
    @PrimaryKey(autoGenerate = true) var id: Int?=null
    @ColumnInfo(name = "prod_id")
    var prod_id: String?=prod_id
    @ColumnInfo(name = "prod_baner")
    var prod_baner: String?=prod_baner
    @ColumnInfo(name = "prod_titel")
    var prod_titel: String?=prod_titel
    @ColumnInfo(name = "prod_rest")
    var prod_rest: String?=prod_rest
    @ColumnInfo(name = "prod_qunty")
    var prod_qunty: String?=prod_qunty
    @ColumnInfo(name = "prod_total")
    var prod_total: String?=prod_total
}