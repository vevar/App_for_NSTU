package com.nstu.data.repository.factory

import android.content.Context
import com.nstu.data.repository.factory.datasource.base.TimeTableBaseDateSource
import com.nstu.data.repository.factory.datasource.base.TimeTableBaseDataSourceImpl
import com.nstu.data.repository.factory.datasource.cloud.TimeTableCloudDataSource
import com.nstu.data.repository.factory.datasource.cloud.TimeTableCloudDataSourceImpl

class TimeTableDataSourceFactory :
    DataSourceFactory<TimeTableBaseDateSource, TimeTableCloudDataSource> {

    //TODO make context
    private lateinit var context: Context

    override fun createBaseDataSource(): TimeTableBaseDateSource {
        return TimeTableBaseDataSourceImpl()
    }

    override fun createCloudDataSource(): TimeTableCloudDataSource {
        return TimeTableCloudDataSourceImpl(context)
    }

}
