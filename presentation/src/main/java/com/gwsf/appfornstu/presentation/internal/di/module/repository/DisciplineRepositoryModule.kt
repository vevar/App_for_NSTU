package com.gwsf.appfornstu.presentation.internal.di.module.repository

import com.gwsf.appfornstu.data.repository.DisciplineRepositoryBC
import com.gwsf.appfornstu.presentation.internal.di.DataScope
import com.gwsf.domain.repository.concrete.DisciplineRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DisciplineRepositoryModule {

    @Provides
    fun provideDisciplineRepository(disciplineRepositoryBC: DisciplineRepositoryBC): DisciplineRepository {
        return disciplineRepositoryBC
    }


}