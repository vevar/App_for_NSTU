package com.nstu.data.repository.factory.datasource.cloud

import com.nstu.data.entity.DayEntity
import io.reactivex.Completable

class DayCloudDataSourceImpl: DayCloudDataSource {

    override fun saveAll(listDays: List<DayEntity>): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}