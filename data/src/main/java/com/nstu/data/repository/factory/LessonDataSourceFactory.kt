package com.nstu.data.repository.factory

import com.nstu.data.repository.factory.datasource.base.LessonBaseDataSource
import com.nstu.data.repository.factory.datasource.base.LessonBaseDataSourceImpl
import com.nstu.data.repository.factory.datasource.cloud.LessoCloudDataSourceImpl
import com.nstu.data.repository.factory.datasource.cloud.LessonCloudDataSource

class LessonDataSourceFactory :
    DataSourceFactory<LessonBaseDataSource, LessonCloudDataSource> {
    override fun createBaseDataSource(): LessonBaseDataSource {
        return LessonBaseDataSourceImpl()
    }

    override fun createCloudDataSource(): LessonCloudDataSource {
        return LessoCloudDataSourceImpl()
    }


}