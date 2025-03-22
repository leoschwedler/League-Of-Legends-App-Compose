package com.example.league_of_legends_app_compose.features.signup.data.repository

import android.util.Log
import com.example.league_of_legends_app_compose.commom.data.local.dao.UserDao
import com.example.league_of_legends_app_compose.commom.data.local.entity.UserEntity
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(private val userDao: UserDao) : SignUpRepository {
    override suspend fun insertAll(
        email: String,
        username: String,
        password: String
    ) {
        try {
            val userEntity = UserEntity(email = email, username = username, password = password)
            userDao.insert(userEntity)
            Log.d("SignUpRepositoryImpl", "Usuário inserido com sucesso")
        } catch (e: Exception) {
            Log.e("SignUpRepositoryImpl", "Erro ao inserir usuário: ${e.message} ")
        }
    }
}