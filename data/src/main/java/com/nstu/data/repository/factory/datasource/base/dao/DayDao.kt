package com.nstu.data.repository.factory.datasource.base.dao

import com.nstu.data.entity.DayEntity
import io.reactivex.Completable

interface DayDao {

    fun saveAll(listDays: List<DayEntity>): Completable
}