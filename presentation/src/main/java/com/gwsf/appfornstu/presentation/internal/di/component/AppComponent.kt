package com.gwsf.appfornstu.presentation.internal.di.component

import android.content.Context
import com.gwsf.appfornstu.presentation.internal.di.module.app.EnvironmentModule
import com.gwsf.domain.executor.ExecutorThread
import com.gwsf.domain.executor.PostExecutorThread
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [EnvironmentModule::class]
)
interface AppComponent {

    fun context(): Context

    fun executorThread(): ExecutorThread

    fun postExecutorThread(): PostExecutorThread

}