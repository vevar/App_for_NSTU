package com.gwsf.appfornstu.presentation.internal.di.module

import androidx.lifecycle.ViewModelProvider
import com.gwsf.appfornstu.presentation.feature.discipline.vm.DisciplineViewModelFactory
import com.gwsf.appfornstu.presentation.internal.di.ScreenScope
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ViewModelModule {
    @Provides
    @Singleton
    fun provideViewModelFactory(disciplineViewModelFactory: DisciplineViewModelFactory)
            : ViewModelProvider.Factory {
        return disciplineViewModelFactory
    }

}