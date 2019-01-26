package com.gwsf.appfornstu.data.entity

data class LessonEntity(
    val id: Int,
    val disciplineId: Int,
    val type: String,
    val topic: String,
    val timeStart: String,
    val timeEnd: String
)