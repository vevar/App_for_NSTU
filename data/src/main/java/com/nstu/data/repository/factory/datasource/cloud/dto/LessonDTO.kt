package com.nstu.data.repository.factory.datasource.cloud.dto

class LessonDTO(
    val id: Int,
    val professor: ProfessorDTO,
    val timeDTO: TimeDTO
) {
    data class TimeDTO(
        val start: String,
        val end: String
    )
}
