package com.example.foodeze.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface CarDAO {
    @Query("Select * from TestProdut")
    List<TestProdut> getAllUsers();

    @Insert
    void insertUser(TestProdut user);

    /*@Update
    void updateUser(ProdCart user);

    @Delete
    void deleteUser(ProdCart user);*/
}
