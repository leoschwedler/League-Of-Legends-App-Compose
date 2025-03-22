package com.example.league_of_legends_app_compose.di

import android.content.Context
import androidx.room.Room
import com.example.league_of_legends_app_compose.commom.data.local.dao.UserDao
import com.example.league_of_legends_app_compose.commom.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext content: Context): AppDatabase {
        return Room.databaseBuilder(
            content,
            AppDatabase::class.java, "database-league-of-legends"
        ).build()
    }

    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase): UserDao {
        return database.userDao()
    }

}