package com.nstu.data.util.mapper

import com.nstu.data.entity.TimeTableEntity
import com.nstu.data.repository.factory.datasource.cloud.dto.TimeTableDTO
import com.nstu.domain.model.timetable.Day
import com.nstu.domain.model.timetable.TimeTable

class TimeTableDataMapper {

    companion object {

        fun convert(timeTableDTO: TimeTableDTO): TimeTableEntity {
            return TimeTableEntity(
                timeTableDTO.id,
                timeTableDTO.listDays.map { it.id }
            )
        }

        fun convert(timeTableEntity: TimeTableEntity, listDays: List<Day>): TimeTable{
            return TimeTable(
                timeTableEntity.id,

                )
        }
    }

}