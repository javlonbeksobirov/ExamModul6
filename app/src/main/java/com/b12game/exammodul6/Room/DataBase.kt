package com.b12game.exammodul6.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.b12game.exammodul6.Room.dao.PostDao
import com.b12game.exammodul6.Room.entity.Card


@Database(entities = [Card::class], version = 1)
abstract class DataBase : RoomDatabase() {

    abstract fun postDao(): PostDao

    companion object {
        private var instance: DataBase? = null

        @Synchronized
        fun getInstance(context: Context):DataBase{
            if(instance == null){
                instance = Room.databaseBuilder(context,DataBase::class.java,"card.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }

}