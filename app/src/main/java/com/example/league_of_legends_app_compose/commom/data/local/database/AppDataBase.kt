package com.example.league_of_legends_app_compose.commom.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.league_of_legends_app_compose.commom.data.local.dao.UserDao
import com.example.league_of_legends_app_compose.commom.data.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}