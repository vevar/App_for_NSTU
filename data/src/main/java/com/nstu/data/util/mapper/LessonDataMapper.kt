package com.nstu.data.util.mapper

import com.nstu.data.entity.LessonEntity
import com.nstu.data.repository.factory.datasource.cloud.dto.LessonDTO

class LessonDataMapper {
    companion object {
        fun convert(lessonDTO: LessonDTO): LessonEntity {
            return LessonEntity(
                lessonDTO.id,
                lessonDTO.disciplineDTO.id,
                lessonDTO.professorDTO.id,
                lessonDTO.type,
                lessonDTO.topic,
                lessonDTO.timeDTO.start,
                lessonDTO.timeDTO.end
            )
        }
    }
}