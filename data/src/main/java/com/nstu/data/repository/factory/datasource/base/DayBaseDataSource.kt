package com.nstu.data.repository.factory.datasource.base

import com.nstu.data.entity.DayEntity
import io.reactivex.Completable

interface DayBaseDataSource {
    fun save(convertedListDays: List<DayEntity>): Completable
}