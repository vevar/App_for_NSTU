package com.nstu.data.util.mapper

import com.nstu.data.entity.UserEntity
import com.nstu.data.repository.factory.datasource.cloud.dto.ProfessorDTO

class ProfessorDataMapper {

    companion object {
        // TODO BAD hardcode
        const val PROFESSOR_TYPE = "professor"

        fun convert(professorDTO: ProfessorDTO): UserEntity {
            return UserEntity(
                professorDTO.id,
                professorDTO.firstName,
                professorDTO.secondName,
                professorDTO.middleName,
                PROFESSOR_TYPE
            )
        }
    }


}