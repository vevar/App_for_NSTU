package com.gwsf.appfornstu.presentation.internal.di.module

import com.gwsf.appfornstu.data.repository.DisciplineRepositoryBC
import com.gwsf.domain.repository.concrete.DisciplineRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideDisciplineRepository(disciplineRepositoryBC: DisciplineRepositoryBC): DisciplineRepository {
        return disciplineRepositoryBC
    }


}