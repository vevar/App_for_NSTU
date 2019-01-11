package com.alxminyaev.appfornstu.database

import android.arch.persistence.room.RoomDatabase

abstract class AppDataBase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME: String = "com.alxminyaev.appfornstu.database"
    }
}