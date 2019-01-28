package com.gwsf.appfornstu.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gwsf.appfornstu.data.database.entity.DisciplineEntity
import com.gwsf.appfornstu.data.repository.factory.datasource.base.dao.DisciplineDao

@Database(entities = [DisciplineEntity::class], version = AppDataBase.VERSION_DATABASE)
abstract class AppDataBase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME: String = "com.gwsf.appfornstu.database"
        const val VERSION_DATABASE: Int = 1
    }

    abstract fun getDisciplineDao(): DisciplineDao
}