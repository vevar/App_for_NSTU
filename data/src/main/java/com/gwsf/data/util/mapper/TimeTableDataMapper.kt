package com.gwsf.data.util.mapper

import com.gwsf.data.entity.TimeTableEntity
import com.gwsf.data.repository.factory.datasource.cloud.dto.TimeTableDTO

class TimeTableDataMapper {

    companion object {

        fun convert(timeTableDTO: TimeTableDTO): TimeTableEntity {
            return TimeTableEntity(
                timeTableDTO.id,
                timeTableDTO.listDays.flatMap { dayDTO ->
                    dayDTO.disciplines.map { it.id }
                }
            )
        }

    }

}