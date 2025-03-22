package com.example.league_of_legends_app_compose.commom.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.league_of_legends_app_compose.commom.data.local.entity.UserEntity

@Dao
interface UserDao {

    @Insert
    fun insert(user: UserEntity)

    @Query("SELECT * FROM user_table WHERE email = :email AND password = :password LIMIT 1")
    fun getUserByEmailAndPassword(email: String, password: String): UserEntity?
}