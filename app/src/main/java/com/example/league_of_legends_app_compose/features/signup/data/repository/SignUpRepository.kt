package com.example.league_of_legends_app_compose.features.signup.data.repository

import androidx.room.Insert
import androidx.room.Query
import com.example.league_of_legends_app_compose.commom.data.local.entity.UserEntity

interface SignUpRepository {

   suspend fun insertAll(email: String, username: String, password: String)

}