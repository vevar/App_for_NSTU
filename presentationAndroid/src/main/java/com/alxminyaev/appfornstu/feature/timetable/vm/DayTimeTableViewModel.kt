package com.alxminyaev.appfornstu.feature.timetable.vm


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.nstu.domain.model.timetable.TimeTable

class DayTimeTableViewModel : ViewModel() {

    val mTimeTable: MutableLiveData<TimeTable> = MutableLiveData()

    fun loadTimeTable() {
    }
}
