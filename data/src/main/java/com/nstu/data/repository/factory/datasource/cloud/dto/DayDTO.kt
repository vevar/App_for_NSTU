package com.nstu.data.repository.factory.datasource.cloud.dto

data class DayDTO(
    val id: Int,
    val date: String,
    val listLessons: List<LessonDTO>
)