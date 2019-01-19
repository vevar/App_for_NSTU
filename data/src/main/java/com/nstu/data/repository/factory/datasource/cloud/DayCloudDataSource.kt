package com.nstu.data.repository.factory.datasource.cloud

import com.nstu.data.entity.DayEntity
import io.reactivex.Completable

interface DayCloudDataSource {

    fun saveAll(listDays: List<DayEntity>) : Completable
}