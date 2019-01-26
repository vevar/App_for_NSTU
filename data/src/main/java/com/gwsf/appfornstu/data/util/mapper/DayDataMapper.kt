package com.gwsf.appfornstu.data.util.mapper

import com.gwsf.domain.model.timetable.Day
import com.gwsf.domain.model.timetable.Week
import com.gwsf.appfornstu.data.entity.DayEntity
import com.gwsf.appfornstu.data.repository.factory.datasource.cloud.dto.DayDTO


class DayDataMapper {
    companion object {
        fun convert(dayDTO: DayDTO): DayEntity {
            TODO()
        }

        fun convert(listDays: List<Day>): List<Week> {
            TODO()
        }
    }


}