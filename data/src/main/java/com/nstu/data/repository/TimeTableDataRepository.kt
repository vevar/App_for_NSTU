package com.nstu.data.repository

import com.nstu.data.entity.mapper.TimeTableDataMapper
import com.nstu.data.repository.factory.TimeTableDataSourceFactory
import com.nstu.domain.model.timetable.TimeTable
import com.nstu.domain.repository.TimeTableRepository
import io.reactivex.Maybe

class TimeTableDataRepository : TimeTableRepository {

    private lateinit var timeTableDataMapper: TimeTableDataMapper
    private lateinit var factoryTimeTable: TimeTableDataSourceFactory

    override fun findByUserId(userId: Int): Maybe<TimeTable> {
        return factoryTimeTable.createBaseDataSource()
            .getByUserId(userId)
            .map { timeTableDataMapper.convert(it) }
    }



}