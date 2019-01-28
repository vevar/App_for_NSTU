package com.gwsf.appfornstu.presentation.internal.di.component

import android.content.Context
import com.gwsf.appfornstu.presentation.internal.di.module.DataSourceModule
import com.gwsf.appfornstu.presentation.internal.di.module.EnvironmentModule
import com.gwsf.appfornstu.presentation.internal.di.module.RepositoryModule
import com.gwsf.domain.executor.ExecutorThread
import com.gwsf.domain.executor.PostExecutorThread
import com.gwsf.domain.repository.concrete.DisciplineRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [EnvironmentModule::class, RepositoryModule::class, DataSourceModule::class]
)
interface AppComponent {

    fun context(): Context

    fun executorThread(): ExecutorThread

    fun postExecutorThread(): PostExecutorThread

    fun disciplineRepository(): DisciplineRepository


}