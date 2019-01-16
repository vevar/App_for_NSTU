package com.nstu.data.repository.factory

interface DataSourceFactory<T> {

    fun createBaseDataSource(): T

    fun createCloudDataSource(): T
}