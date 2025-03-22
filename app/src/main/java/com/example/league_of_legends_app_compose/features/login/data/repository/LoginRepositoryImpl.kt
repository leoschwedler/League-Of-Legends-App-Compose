package com.example.league_of_legends_app_compose.features.login.data.repository

import android.util.Log
import com.example.league_of_legends_app_compose.commom.data.local.dao.UserDao
import com.example.league_of_legends_app_compose.features.login.domain.UserUiData
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val userDao: UserDao) : LoginRepository {

    private val TAG = "LoginRepositoryImpl"

    override suspend fun login(email: String, password: String): Result<UserUiData?> {
        return try {
            Log.d(TAG, "Tentativa de login com email: $email")

            val userEntity = userDao.getUserByEmailAndPassword(email = email, password = password)
            if (userEntity == null) {
                Log.d(TAG, "Usuário não encontrado para o email: $email")
                throw Exception("Usuário não encontrado")
            } else {
                Log.d(TAG, "Usuário encontrado: $userEntity")
            }

            val userUiData = UserUiData(
                email = userEntity.email!!,
                password = userEntity.password!!
            )
            Log.d(TAG, "Login efetuado com sucesso: $userUiData")
            Result.success(userUiData)
        } catch (e: Exception) {
            Log.e(TAG, "Erro durante o login: ${e.message}", e)
            Result.failure(e)
        }
    }
}
