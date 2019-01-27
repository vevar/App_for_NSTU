package com.gwsf.appfornstu.presentation.internal.di.module

import com.gwsf.appfornstu.data.repository.factory.datasource.DisciplineDataSource
import com.gwsf.appfornstu.data.repository.factory.datasource.base.DisciplineBaseDataSource
import com.gwsf.appfornstu.data.repository.factory.datasource.base.dao.DisciplineDao
import dagger.Module
import javax.inject.Named

@Module
class DataSourceModule {

    companion object {
        const val TYPE_NAME_BASE = "Base"
    }

    @Named(TYPE_NAME_BASE)
    fun provideDisciplineDataSource(disciplineDao: DisciplineDao): DisciplineDataSource {
        return DisciplineBaseDataSource(disciplineDao)
    }

}