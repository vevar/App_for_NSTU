package com.gwsf.appfornstu.presentation.internal.di.module.repository

import com.gwsf.appfornstu.data.repository.EventRepositoryBC
import com.gwsf.domain.repository.concrete.EventRepository
import dagger.Module
import dagger.Provides

@Module
class EventRepositoryModule {

    @Provides
    fun provideEventRepository(eventRepositoryBC: EventRepositoryBC): EventRepository {
        return eventRepositoryBC
    }
}