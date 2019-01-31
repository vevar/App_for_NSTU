package com.gwsf.appfornstu.presentation

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.gwsf.appfornstu.data.database.AppDataBase
import com.gwsf.appfornstu.presentation.internal.di.component.AppComponent
import com.gwsf.appfornstu.presentation.internal.di.component.DaggerAppComponent
import com.gwsf.appfornstu.presentation.internal.di.component.listdisciplines.DaggerListDisciplinesComponent
import com.gwsf.appfornstu.presentation.internal.di.component.listdisciplines.ListDisciplinesComponent
import com.gwsf.appfornstu.presentation.internal.di.component.listevents.DaggerListEventsComponent
import com.gwsf.appfornstu.presentation.internal.di.component.listevents.ListEventsComponent
import com.gwsf.appfornstu.presentation.internal.di.module.app.EnvironmentModule
import com.gwsf.appfornstu.presentation.internal.di.module.dao.DaoModule
import com.gwsf.appfornstu.presentation.internal.di.module.datasource.DisciplineSourceModule
import com.gwsf.appfornstu.presentation.internal.di.module.datasource.EventSourceModule
import com.gwsf.appfornstu.presentation.internal.di.module.repository.DisciplineRepositoryModule
import com.gwsf.appfornstu.presentation.internal.di.module.repository.EventRepositoryModule


class App : Application() {

    private lateinit var dataBase: AppDataBase

    private lateinit var applicationComponent: AppComponent

    private var listDisciplinesComponent: ListDisciplinesComponent? = null
    private var listEventsComponent: ListEventsComponent? = null

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

    private fun initializeInjector() {
        this.applicationComponent = DaggerAppComponent.builder()
            .environmentModule(EnvironmentModule(this))
            .build()

    }

    fun getListDisciplinesComponent(): ListDisciplinesComponent {
        if (listDisciplinesComponent == null) {
            listDisciplinesComponent = DaggerListDisciplinesComponent.builder()
                .disciplineRepositoryModule(DisciplineRepositoryModule())
                .disciplineSourceModule(DisciplineSourceModule(this))
                .daoModule(DaoModule(dataBase))
                .build()
        }

        return listDisciplinesComponent!!
    }

    fun getListEventsComponent(): ListEventsComponent {
        if (listEventsComponent == null) {
            listEventsComponent = DaggerListEventsComponent.builder()
                .eventRepositoryModule(EventRepositoryModule())
                .eventSourceModule(EventSourceModule())
                .daoModule(DaoModule(dataBase))
                .build()
        }

        return listEventsComponent!!
    }
}