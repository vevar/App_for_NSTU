package com.nstu.data.repository.factory.datasource.base

import com.nstu.data.entity.TimeTableEntity
import com.nstu.data.repository.factory.datasource.base.dao.TimeTableDao
import io.reactivex.Completable
import io.reactivex.Maybe

class TimeTableBaseDataSourceImpl : TimeTableBaseDateSource {

    private lateinit var  timeTableDao: TimeTableDao

    override fun save(timeTableEntity: TimeTableEntity): Completable {
        return timeTableDao.save(timeTableEntity)
    }

    override fun getById(id: Int): Maybe<TimeTableEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}