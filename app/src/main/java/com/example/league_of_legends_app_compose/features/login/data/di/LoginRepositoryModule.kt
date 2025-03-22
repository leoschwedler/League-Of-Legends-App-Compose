package com.example.league_of_legends_app_compose.features.login.data.di

import com.example.league_of_legends_app_compose.features.login.data.repository.LoginRepository
import com.example.league_of_legends_app_compose.features.login.data.repository.LoginRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface LoginRepositoryModule {

    @Singleton
    @Binds
    fun bindLoginRepository(loginRepositoryImpl: LoginRepositoryImpl): LoginRepository
}