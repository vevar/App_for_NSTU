package com.gwsf.appfornstu.presentation.internal.di.component.listevents

import com.gwsf.appfornstu.presentation.internal.di.module.dao.DaoModule
import com.gwsf.appfornstu.presentation.internal.di.module.datasource.EventSourceModule
import com.gwsf.appfornstu.presentation.internal.di.module.repository.EventRepositoryModule
import com.gwsf.domain.repository.concrete.EventRepository
import dagger.Component

@Component(
    modules = [EventRepositoryModule::class, EventSourceModule::class, DaoModule::class]
)
interface ListEventsComponent {

    fun eventRepository(): EventRepository

}