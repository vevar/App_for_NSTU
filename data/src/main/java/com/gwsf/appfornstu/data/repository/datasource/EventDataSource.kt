package com.gwsf.appfornstu.data.repository.datasource

import com.gwsf.appfornstu.data.dto.EventDTO
import io.reactivex.Completable
import io.reactivex.Maybe

interface EventDataSource {

    fun getListEventsByDisciplineId(disciplineId: Int): Maybe<List<EventDTO>>

    fun putListEvents(events: List<EventDTO>): Completable
}