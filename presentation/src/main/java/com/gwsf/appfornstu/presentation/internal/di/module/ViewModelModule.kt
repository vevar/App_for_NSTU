package com.gwsf.appfornstu.presentation.internal.di.module

import androidx.lifecycle.ViewModelProvider
import com.gwsf.appfornstu.presentation.feature.listdiscipline.vm.ListDisciplineViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ViewModelModule {
    @Provides
    @Singleton
    fun provideViewModelFactory(listDisciplineViewModelFactory: ListDisciplineViewModelFactory)
            : ViewModelProvider.Factory {
        return listDisciplineViewModelFactory
    }

}