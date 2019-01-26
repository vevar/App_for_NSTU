package com.gwsf.appfornstu.data.repository

import com.gwsf.domain.model.timetable.TimeTable
import com.gwsf.domain.repository.TimeTableRepository
import com.gwsf.appfornstu.data.repository.factory.TimeTableDataSourceFactory
import com.gwsf.appfornstu.data.util.mapper.TimeTableDataMapper
import io.reactivex.Single

class TimeTableDataRepository : TimeTableRepository{

    private lateinit var timeTableDataMapper: TimeTableDataMapper
    private lateinit var factoryTimeTable: TimeTableDataSourceFactory


    override fun findById(id: Int): Single<TimeTable> {
        factoryTimeTable.createCloudDataSource()
            .getById(id)

        TODO()
    }


}