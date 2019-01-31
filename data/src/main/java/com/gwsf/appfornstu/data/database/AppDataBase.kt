package com.gwsf.appfornstu.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gwsf.appfornstu.data.database.entity.DisciplineEntity
import com.gwsf.appfornstu.data.database.entity.ProfessorEntity
import com.gwsf.appfornstu.data.repository.datasource.base.dao.DisciplineDao
import com.gwsf.appfornstu.data.repository.datasource.base.dao.EventDao
import com.gwsf.appfornstu.data.repository.datasource.base.dao.ProfessorDao

@Database(
    entities = [DisciplineEntity::class, ProfessorEntity::class],
    version = AppDataBase.VERSION_DATABASE
)
abstract class AppDataBase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME: String = "com.gwsf.appfornstu.database"
        const val VERSION_DATABASE: Int = 3
    }

    abstract fun getDisciplineDao(): DisciplineDao

    abstract fun getProfessorDao(): ProfessorDao

    abstract fun getEventDao(): EventDao
}