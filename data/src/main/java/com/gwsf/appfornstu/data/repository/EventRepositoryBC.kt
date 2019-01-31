package com.gwsf.appfornstu.data.repository

import com.gwsf.appfornstu.data.repository.datasource.EventDataSource
import com.gwsf.appfornstu.data.util.mapper.convert
import com.gwsf.domain.model.event.Event
import com.gwsf.domain.repository.concrete.EventRepository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

class EventRepositoryBC @Inject constructor(
    @Named("Base")
    val eventBaseDataSource: EventDataSource,
    @Named("Cloud")
    val eventCloudDataSource: EventDataSource
) : EventRepository {

    override fun findListEvents(): Observable<List<Event>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findListEventsByDisciplineId(disciplineId: Int): Observable<List<Event>> {
        val base = eventBaseDataSource.getListEventsByDisciplineId(disciplineId)
        val cloud = eventCloudDataSource.getListEventsByDisciplineId(disciplineId)
        cloud.doOnSuccess {
            eventBaseDataSource.putListEvents(it)
        }.subscribe()


        return Observable.merge(base.toObservable(), cloud.toObservable())
            .map {
                it.map { eventDTO ->
                    convert(eventDTO)
                }
            }
    }
}