package com.gwsf.appfornstu.data.util.mapper

import com.gwsf.appfornstu.data.dto.EventDTO
import com.gwsf.domain.model.event.Event

fun convert(eventDTO: EventDTO): Event {
    return Event(
        eventDTO.id,
        eventDTO.name
    )
}