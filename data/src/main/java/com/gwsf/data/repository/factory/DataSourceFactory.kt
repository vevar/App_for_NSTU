package com.gwsf.data.repository.factory

interface DataSourceFactory<T> {

    fun createBaseDataSource(): T

    fun createCloudDataSource(): T
}