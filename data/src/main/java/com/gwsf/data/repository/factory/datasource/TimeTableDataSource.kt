package com.gwsf.data.repository.factory.datasource

import com.gwsf.data.entity.TimeTableEntity
import io.reactivex.Maybe

interface TimeTableDataSource {

    fun getById(id: Int): Maybe<TimeTableEntity>
}