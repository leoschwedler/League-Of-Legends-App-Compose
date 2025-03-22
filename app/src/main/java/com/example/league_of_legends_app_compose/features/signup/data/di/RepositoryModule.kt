package com.example.league_of_legends_app_compose.features.signup.data.di

import com.example.league_of_legends_app_compose.features.signup.data.repository.SignUpRepository
import com.example.league_of_legends_app_compose.features.signup.data.repository.SignUpRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Singleton
    @Binds
    fun bindsSignUpRepository(repositoryImpl: SignUpRepositoryImpl): SignUpRepository
}