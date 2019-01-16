package com.nstu.domain.repository

import com.nstu.domain.model.timetable.TimeTable
import io.reactivex.Maybe
import io.reactivex.Observable

interface TimeTableRepository {

    fun findByUserId(userId: Int): Maybe<TimeTable>
}