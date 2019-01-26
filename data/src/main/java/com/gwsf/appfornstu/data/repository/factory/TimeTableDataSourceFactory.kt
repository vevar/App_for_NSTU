package com.gwsf.appfornstu.data.repository.factory

import android.content.Context
import com.gwsf.appfornstu.data.repository.factory.datasource.TimeTableDataSource
import com.gwsf.appfornstu.data.repository.factory.datasource.cloud.TimeTableCloudDataSource

class TimeTableDataSourceFactory : DataSourceFactory<TimeTableDataSource> {

    //TODO make context
    private lateinit var context: Context

    override fun createBaseDataSource(): TimeTableDataSource {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createCloudDataSource(): TimeTableDataSource {
        return TimeTableCloudDataSource(context)
    }

}
