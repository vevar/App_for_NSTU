package com.gwsf.appfornstu.internal.di.componet

import android.content.Context
import com.gwsf.appfornstu.internal.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun context(): Context
}