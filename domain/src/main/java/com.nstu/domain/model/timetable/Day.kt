package com.nstu.domain.model.timetable

import com.nstu.domain.model.discipline.Discipline
import java.util.*

data class Day(
    val date: Calendar,
    val listDisciplines: List<Discipline>
) {

}
