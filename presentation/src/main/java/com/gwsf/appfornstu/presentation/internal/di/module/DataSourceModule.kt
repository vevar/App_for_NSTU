package com.gwsf.appfornstu.presentation.internal.di.module

import android.content.Context
import com.gwsf.appfornstu.data.repository.factory.datasource.DisciplineDataSource
import com.gwsf.appfornstu.data.repository.factory.datasource.base.DisciplineBaseDataSource
import com.gwsf.appfornstu.data.repository.factory.datasource.base.dao.DisciplineDao
import com.gwsf.appfornstu.data.repository.factory.datasource.cloud.DisciplineCloudDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class DataSourceModule(private val disciplineDao: DisciplineDao, private val context: Context) {

    companion object {
        const val TYPE_NAME_BASE = "Base"
        const val TYPE_NAME_CLOUD = "Cloud"
    }

    @Provides
    @Named(TYPE_NAME_BASE)
    @Singleton
    fun provideDisciplineDataSource(): DisciplineDataSource {
        return DisciplineBaseDataSource(disciplineDao)
    }

    @Provides
    @Named(TYPE_NAME_CLOUD)
    @Singleton
    fun provideDisciplineDateSource(): DisciplineDataSource {
        return DisciplineCloudDataSource(context)
    }

}