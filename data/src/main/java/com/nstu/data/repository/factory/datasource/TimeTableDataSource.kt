package com.nstu.data.repository.factory.datasource

import com.nstu.data.entity.TimeTableEntity
import io.reactivex.Maybe

interface TimeTableDataSource {

    fun getById(id: Int): Maybe<TimeTableEntity>
}