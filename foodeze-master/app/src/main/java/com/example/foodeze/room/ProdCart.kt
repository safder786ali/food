package com.example.foodeze.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "ProdCart")
class ProdCart{
    @PrimaryKey(autoGenerate = true) var id: Int?=null
    @ColumnInfo(name = "prod_id") var prod_id: String?=""
    @ColumnInfo(name = "prod_baner") var prod_baner: String?=""
    @ColumnInfo(name = "prod_titel") var prod_titel: String?=""
    @ColumnInfo(name = "prod_rest") var prod_rest: String?=""
    @ColumnInfo(name = "prod_qunty") var prod_qunty: String?=""
    @ColumnInfo(name = "prod_total") var prod_total: String?=""

}

