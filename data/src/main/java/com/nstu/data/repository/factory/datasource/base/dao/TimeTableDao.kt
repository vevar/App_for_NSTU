package com.nstu.data.repository.factory.datasource.base.dao

import com.nstu.data.entity.TimeTableEntity
import io.reactivex.Completable

interface TimeTableDao {
    fun save(timeTableEntity: TimeTableEntity): Completable
}