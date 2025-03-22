package com.example.league_of_legends_app_compose.features.login.data.repository

import com.example.league_of_legends_app_compose.features.login.domain.UserUiData

interface LoginRepository {
    suspend fun login(email: String, password: String): Result<UserUiData?>
}