package com.gwsf.appfornstu.presentation.internal.di.module.datasource

import com.gwsf.appfornstu.data.repository.datasource.EventDataSource
import com.gwsf.appfornstu.data.repository.datasource.base.EventBaseDataSource
import com.gwsf.appfornstu.data.repository.datasource.base.dao.EventDao
import com.gwsf.appfornstu.data.repository.datasource.cloud.EventCloudDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class EventSourceModule {

    @Provides
    @Named("Base")
    fun provideEventBaseDataSource(eventDao: EventDao): EventDataSource {
        return EventBaseDataSource(eventDao)
    }

    @Provides
    @Named("Cloud")
    fun provideEventCloudDateSource(): EventDataSource {
        return EventCloudDataSource()
    }

}