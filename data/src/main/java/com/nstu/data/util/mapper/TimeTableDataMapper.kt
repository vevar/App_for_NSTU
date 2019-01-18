package com.nstu.data.util.mapper

import com.nstu.data.entity.TimeTableEntity
import com.nstu.data.repository.factory.datasource.cloud.dto.TimeTableDTO

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