package com.gwsf.appfornstu.data.repository.factory

interface DataSourceFactory<T> {

    fun createBaseDataSource(): T

    fun createCloudDataSource(): T
}