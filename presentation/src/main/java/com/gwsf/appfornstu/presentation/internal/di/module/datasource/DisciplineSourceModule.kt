package com.gwsf.appfornstu.presentation.internal.di.module.datasource

import android.content.Context
import com.gwsf.appfornstu.data.repository.datasource.DisciplineDataSource
import com.gwsf.appfornstu.data.repository.datasource.base.DisciplineBaseDataSource
import com.gwsf.appfornstu.data.repository.datasource.base.dao.DisciplineDao
import com.gwsf.appfornstu.data.repository.datasource.base.dao.ProfessorDao
import com.gwsf.appfornstu.data.repository.datasource.cloud.DisciplineCloudDataSource
import dagger.Lazy
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class DisciplineSourceModule(
    private val context: Context
) {

    companion object {
        const val TYPE_NAME_BASE = "Base"
        const val TYPE_NAME_CLOUD = "Cloud"
    }

    @Provides
    @Named(TYPE_NAME_BASE)
    fun provideDisciplineBaseDataSource(
        disciplineDao: DisciplineDao,
        professorDao: Lazy<ProfessorDao>
    ): DisciplineDataSource {
        return DisciplineBaseDataSource(disciplineDao, professorDao)
    }

    @Provides
    @Named(TYPE_NAME_CLOUD)
    fun provideDisciplineCloudDataSource(): DisciplineDataSource {
        return DisciplineCloudDataSource(context)
    }

}