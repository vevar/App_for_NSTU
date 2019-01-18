package com.nstu.data.util.mapper

import com.nstu.data.entity.DayEntity
import com.nstu.data.repository.factory.datasource.cloud.dto.DayDTO
import com.nstu.domain.model.timetable.Day
import com.nstu.domain.model.timetable.Week
import java.text.SimpleDateFormat
import java.util.*

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