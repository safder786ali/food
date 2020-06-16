package com.example.foodeze.room

import androidx.room.*


@Dao
interface HirstoryDAO {


    @Query("Select * from HistoryProdut")
    fun getAllHistory(): List<HistoryProdut>
    @Insert
    fun InsertHistory(hist:HistoryProdut)

    @Update
    fun UpdateHistory(hist:HistoryProdut)

    @Delete
    fun DeleteHistory(hist:HistoryProdut)

    @Insert
    fun HistoryMult(historylist: List<HistoryProdut>)
}