package com.gwsf.appfornstu.data.repository.datasource.cloud

import com.gwsf.appfornstu.data.dto.EventDTO
import com.gwsf.appfornstu.data.repository.datasource.EventDataSource
import io.reactivex.Completable
import io.reactivex.Maybe

class EventCloudDataSource : EventDataSource {

    override fun getListEventsByDisciplineId(disciplineId: Int): Maybe<List<EventDTO>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun putListEvents(events: List<EventDTO>): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}