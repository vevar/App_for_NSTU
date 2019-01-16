package com.alxminyaev.appfornstu.feature.timetable.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DayTimeTableModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        val localDataSource: LocalDataSource = LocalDataSourceImpl()
        val remoteDataSource: RemoteDataSource = RemoteDataSourceImpl()

        val repository: DayTimeTableRepository = DayTimeTableRepositoryImpl(localDataSource, remoteDataSource)
        val itenteractor = DayTimeTableInteractorImpl(repository)

        return DayTimeTableViewModel(itenteractor) as T
    }
}