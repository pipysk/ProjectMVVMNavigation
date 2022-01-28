package com.example.projectmvvmnavigation.data.db

import androidx.room.*
import com.example.projectmvvmnavigation.data.entities.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): Flow<List<User>?>

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE id IN (:id)")
    fun loadById(id: Int): List<User>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)
}