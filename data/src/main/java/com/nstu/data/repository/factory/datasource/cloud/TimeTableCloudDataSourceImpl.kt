package com.nstu.data.repository.factory.datasource.cloud

import android.content.Context
import com.nstu.data.repository.factory.datasource.cloud.dto.DayDTO
import com.nstu.data.repository.factory.datasource.cloud.dto.LessonDTO
import com.nstu.data.repository.factory.datasource.cloud.dto.TimeTableDTO
import com.nstu.data.util.mapper.DayDataMapper
import com.nstu.data.util.mapper.DisciplineDataMapper
import com.nstu.data.util.mapper.LessonDataMapper
import com.nstu.data.util.mapper.ProfessorDataMapper
import com.nstu.data.util.parser.ParserTimeTable
import com.nstu.data.util.parser.ParserTimeTableJson
import io.reactivex.Maybe

class TimeTableCloudDataSourceImpl(private val context: Context) : TimeTableCloudDataSource {

    private val parserTimeTable: ParserTimeTable = ParserTimeTableJson()


    override fun getById(id: Int): Maybe<TimeTableDTO> {
        val inputStream = context.assets.open("timetable/time_table_json.json")

        val timeTableDTO = parserTimeTable.parse(inputStream)

        val maybeTimeTableDTO = Maybe.just(timeTableDTO)

        return maybeTimeTableDTO
    }


}