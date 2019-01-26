package com.gwsf.appfornstu.data.repository.factory.datasource.cloud

import android.content.Context
import com.gwsf.appfornstu.data.entity.TimeTableEntity
import com.gwsf.appfornstu.data.repository.factory.datasource.TimeTableDataSource
import com.gwsf.appfornstu.data.util.mapper.TimeTableDataMapper
import com.gwsf.appfornstu.data.util.parser.ParserTimeTable
import com.gwsf.appfornstu.data.util.parser.ParserTimeTableJson
import io.reactivex.Maybe

class TimeTableCloudDataSource(private val context: Context) : TimeTableDataSource {

    private val parserTimeTable: ParserTimeTable = ParserTimeTableJson()

    override fun getById(id: Int): Maybe<TimeTableEntity> {
        val inputStream = context.assets.open("timetable/time_table_json.txt")
        val timeTableDTO = parserTimeTable.parse(inputStream)

        return Maybe.just(timeTableDTO)
            .map { TimeTableDataMapper.convert(it) }
    }
}