package com.example.foodeze.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(TestProdut::class),(HistoryProdut::class)], version = 2, exportSchema = false)
 abstract class CartDataBase: RoomDatabase() {
    var cartDB: CartDataBase? = null

    abstract fun cartDAO(): CartDAO
    abstract  fun historyDAO():HirstoryDAO


    companion object {


        private var INSTANCE: CartDataBase? = null

        fun getDatabase(context: Context): CartDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CartDataBase::class.java,
                    "user19b2"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}


