package com.gwsf.appfornstu.presentation

import android.app.Application
import android.content.Context
import com.gwsf.appfornstu.presentation.internal.di.component.AppComponent
import com.gwsf.appfornstu.presentation.internal.di.component.DaggerAppComponent
import com.gwsf.appfornstu.presentation.internal.di.component.DaggerScreenComponent
import com.gwsf.appfornstu.presentation.internal.di.component.ScreenComponent
import com.gwsf.appfornstu.presentation.internal.di.module.EnvironmentModule
import com.gwsf.appfornstu.presentation.internal.di.module.RepositoryModule


class App : Application() {

    private lateinit var applicationComponent: AppComponent
    private lateinit var screenComponent: ScreenComponent


    companion object {
        fun getApp(context: Context): App {
            return context.applicationContext as App
        }
    }

    override fun onCreate() {
        super.onCreate()
        initializeInjector()
    }

    fun getApplicationComponent(): AppComponent {
        return applicationComponent
    }

    fun getScreenComponent(): ScreenComponent {
        return screenComponent
    }

    private fun initializeInjector() {
        this.applicationComponent = DaggerAppComponent.builder()
            .environmentModule(EnvironmentModule(this))
            .repositoryModule(RepositoryModule())
            .build()

        this.screenComponent = DaggerScreenComponent.builder()
            .appComponent(applicationComponent)
            .build()
    }
}