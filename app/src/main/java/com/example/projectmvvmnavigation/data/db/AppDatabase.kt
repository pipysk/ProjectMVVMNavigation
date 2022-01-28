package com.example.projectmvvmnavigation.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.projectmvvmnavigation.data.entities.User
import com.example.projectmvvmnavigation.utils.DATABASE_NAME

@Database(entities = [User::class], version = 1)
abstract class AppDatabase:RoomDatabase(){
    abstract fun userDao():UserDao

    companion object{

        @Volatile
        private var instance: AppDatabase? =null

        fun getInstance(context:Context):AppDatabase{
            return instance?: synchronized(this)
            {
                instance?: buildDatabase(context).also {
                    instance=it
                }
            }
        }

        private fun buildDatabase(context: Context):AppDatabase{
            return Room.databaseBuilder(context,AppDatabase::class.java, DATABASE_NAME)
                .build()
        }
    }

}
