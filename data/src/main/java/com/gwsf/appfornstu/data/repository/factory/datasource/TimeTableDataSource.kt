package com.gwsf.appfornstu.data.repository.factory.datasource

import com.gwsf.appfornstu.data.entity.TimeTableEntity
import io.reactivex.Maybe

interface TimeTableDataSource {

    fun getById(id: Int): Maybe<TimeTableEntity>
}