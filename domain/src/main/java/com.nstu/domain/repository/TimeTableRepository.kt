package com.nstu.domain.repository

import com.nstu.domain.model.timetable.TimeTable
import io.reactivex.Maybe

interface TimeTableRepository {

    fun findById(id: Int): Maybe<TimeTable>
}