package com.nstu.data.entity

data class LessonEntity(
    val id: Int,
    val type: String,
    val topic: String,
    val timeStart: String,
    val timeEnd: String
)