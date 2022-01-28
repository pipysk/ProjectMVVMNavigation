package com.example.projectmvvmnavigation.data.db

import androidx.room.*
import com.example.projectmvvmnavigation.data.entities.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT*FROM user")
    fun getAll(): Flow<List<User>?>
}