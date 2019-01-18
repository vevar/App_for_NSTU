package com.nstu.data.repository

import com.nstu.data.util.mapper.TimeTableDataMapper
import com.nstu.data.repository.factory.TimeTableDataSourceFactory
import com.nstu.domain.model.timetable.TimeTable
import com.nstu.domain.repository.TimeTableRepository
import io.reactivex.Maybe

class TimeTableDataRepository : TimeTableRepository {

    private lateinit var timeTableDataMapper: TimeTableDataMapper
    private lateinit var factoryTimeTable: TimeTableDataSourceFactory


    override fun findById(id: Int): Maybe<TimeTable> {
        factoryTimeTable.createCloudDataSource()
            .getById(id)

        TODO()
    }


}