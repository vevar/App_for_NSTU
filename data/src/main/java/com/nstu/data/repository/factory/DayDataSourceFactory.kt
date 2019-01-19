package com.nstu.data.repository.factory

import com.nstu.data.repository.factory.datasource.cloud.DayCloudDataSource
import com.nstu.data.repository.factory.datasource.base.DayBaseDataSource
import com.nstu.data.repository.factory.datasource.base.DayBaseDataSourceImpl
import com.nstu.data.repository.factory.datasource.cloud.DayCloudDataSourceImpl

class DayDataSourceFactory :
    DataSourceFactory<DayBaseDataSource, DayCloudDataSource> {

    override fun createBaseDataSource(): DayBaseDataSource {
        return DayBaseDataSourceImpl()
    }

    override fun createCloudDataSource(): DayCloudDataSource {
        return DayCloudDataSourceImpl()
    }

}
