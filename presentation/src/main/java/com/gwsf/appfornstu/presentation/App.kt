package com.gwsf.appfornstu.presentation

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.gwsf.appfornstu.data.database.AppDataBase
import com.gwsf.appfornstu.presentation.internal.di.component.AppComponent
import com.gwsf.appfornstu.presentation.internal.di.component.DaggerAppComponent
import com.gwsf.appfornstu.presentation.internal.di.component.DaggerScreenComponent
import com.gwsf.appfornstu.presentation.internal.di.component.ScreenComponent
import com.gwsf.appfornstu.presentation.internal.di.module.DataSourceModule
import com.gwsf.appfornstu.presentation.internal.di.module.EnvironmentModule
import com.gwsf.appfornstu.presentation.internal.di.module.RepositoryModule


class App : Application() {

    private lateinit var dataBase: AppDataBase

    private lateinit var applicationComponent: AppComponent
    private lateinit var screenComponent: ScreenComponent

    companion object {
        fun getApp(context: Context): App {
            return context.applicationContext as App
        }

    }

    override fun onCreate() {
        super.onCreate()

        dataBase = Room.databaseBuilder(
            getApp(this),
            AppDataBase::class.java,
            AppDataBase.DATABASE_NAME
        ).build()

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
            .dataSourceModule(DataSourceModule(App.getApp(this).dataBase.getDisciplineDao(), this))
            .build()

        this.screenComponent = DaggerScreenComponent.builder()
            .appComponent(applicationComponent)
            .build()
    }
}