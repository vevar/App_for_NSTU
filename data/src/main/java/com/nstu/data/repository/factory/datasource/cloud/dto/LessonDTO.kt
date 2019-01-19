package com.nstu.data.repository.factory.datasource.cloud.dto

class LessonDTO(
    val id: Int,
    val disciplineDTO: DisciplineDTO,
    val professorDTO: ProfessorDTO,
    val type: String,
    val timeDTO: TimeDTO,
    val topic: String
) {
    data class TimeDTO(
        val start: String,
        val end: String
    )
}
