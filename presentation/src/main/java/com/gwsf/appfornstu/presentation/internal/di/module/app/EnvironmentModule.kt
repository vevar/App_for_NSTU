package com.gwsf.appfornstu.presentation.internal.di.module.app

import android.content.Context
import com.gwsf.appfornstu.presentation.App
import com.gwsf.appfornstu.data.executor.JobExecutor
import com.gwsf.appfornstu.presentation.executer.UIThread
import com.gwsf.domain.executor.ExecutorThread
import com.gwsf.domain.executor.PostExecutorThread
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class EnvironmentModule(private val app: App) {

    @Provides
    @Singleton
    fun provideAppContext(): Context {
        return app
    }

    @Provides
    @Singleton
    fun provideExecutorThread(jobExecutor: JobExecutor): ExecutorThread {
        return jobExecutor
    }

    @Provides
    @Singleton
    fun providePostExecutorThread(uiThread: UIThread): PostExecutorThread {
        return uiThread
    }

}
