package com.example.foodeze.room

import androidx.room.*

@Dao
interface CartDAO {

    @Query("Select * from TestProdut")
     fun getAllUsers(): List<TestProdut>
    @Insert
    fun InsertProd(prod:TestProdut)

    @Update
    fun UpdateProd(prod:TestProdut)

    @Delete
    fun DeleteProd(prod:TestProdut)
}