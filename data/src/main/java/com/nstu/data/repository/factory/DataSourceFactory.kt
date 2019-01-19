package com.nstu.data.repository.factory

interface DataSourceFactory<B, C> {

    fun createBaseDataSource(): B

    fun createCloudDataSource(): C
}