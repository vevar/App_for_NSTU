package com.gwsf.appfornstu.presentation.internal.di.module

import android.content.Context
import com.gwsf.appfornstu.presentation.App
import com.gwsf.appfornstu.data.executor.JobExecutor
import com.gwsf.domain.executor.ExecutorThread
import com.gwsf.domain.executor.PostExecutorThread
import dagger.Provides
import javax.inject.Singleton

//@Module
class ApplicationModule(private val app: App) {

//    @Singleton
//    @Provides
    fun provideAppContext(): Context {
        return app
    }

//    @Singleton
//    @Provides
//    fun provideExecutorThread(jobExecutor: JobExecutor): ExecutorThread {
//        return jobExecutor
//    }


//    @Singleton
//    @Provides
    fun providePostExecuterThread(postExecutorThread: PostExecutorThread){
        return
    }


}