package com.gwsf.appfornstu.data.database

// TODO RoomDatabase()
//@Database(entities = [], version = AppDataBase.VERSION_DATABASE)
abstract class AppDataBase {
    companion object {
        const val DATABASE_NAME: String = "com.alxminyaev.appfornstu.database"
        const val VERSION_DATABASE: Int = 1
    }

    abstract fun getUserDao()
}