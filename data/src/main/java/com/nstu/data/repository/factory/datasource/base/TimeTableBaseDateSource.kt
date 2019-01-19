package com.nstu.data.repository.factory.datasource.base

import com.nstu.data.entity.TimeTableEntity
import io.reactivex.Completable
import io.reactivex.Maybe

interface TimeTableBaseDateSource {

    fun save(timeTableEntity: TimeTableEntity): Completable

    fun getById(id: Int): Maybe<TimeTableEntity>
}