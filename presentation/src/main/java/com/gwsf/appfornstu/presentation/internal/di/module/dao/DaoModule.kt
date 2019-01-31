package com.gwsf.appfornstu.presentation.internal.di.module.dao

import com.gwsf.appfornstu.data.database.AppDataBase
import com.gwsf.appfornstu.data.repository.datasource.base.dao.DisciplineDao
import com.gwsf.appfornstu.data.repository.datasource.base.dao.EventDao
import com.gwsf.appfornstu.data.repository.datasource.base.dao.ProfessorDao
import dagger.Module
import dagger.Provides

@Module
class DaoModule(private val dataBase: AppDataBase) {

    @Provides
    fun provideProfessorDao(): ProfessorDao {
        return dataBase.getProfessorDao()
    }

    @Provides
    fun provideDisciplineDao(): DisciplineDao {
        return dataBase.getDisciplineDao()
    }

    @Provides
    fun provideEventDao(): EventDao {
        return dataBase.getEventDao()
    }
}