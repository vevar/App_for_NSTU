package com.alxminyaev.appfornstu.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nstu.data.user.dao.UserDao
import com.nstu.data.user.entity.UserEntity

@Database(entities = [UserEntity::class], version = AppDataBase.VERSION_DATABASE)
abstract class AppDataBase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME: String = "com.alxminyaev.appfornstu.database"
        const val VERSION_DATABASE: Int = 1
    }

    abstract fun getUserDao(): UserDao
}