package com.nstu.data.database

import androidx.room.Database
import com.nstu.data.entity.UserEntity

// TODO RoomDatabase()
@Database(entities = [UserEntity::class], version = AppDataBase.VERSION_DATABASE)
abstract class AppDataBase {
    companion object {
        const val DATABASE_NAME: String = "com.alxminyaev.appfornstu.database"
        const val VERSION_DATABASE: Int = 1
    }

    abstract fun getUserDao()
}