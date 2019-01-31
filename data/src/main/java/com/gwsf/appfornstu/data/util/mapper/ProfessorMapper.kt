package com.gwsf.appfornstu.data.util.mapper

import com.gwsf.appfornstu.data.database.entity.ProfessorEntity
import com.gwsf.appfornstu.data.dto.ProfessorDTO
import com.gwsf.domain.model.user.Professor

class ProfessorMapper {
    companion object {
        fun convert(professorEntity: ProfessorEntity): ProfessorDTO {
            val professorDTO = ProfessorDTO(
                professorEntity.id,
                professorEntity.firstName,
                professorEntity.surName
            )

            professorDTO.middleName = professorEntity.middleName
            professorDTO.email = professorEntity.email

            return professorDTO
        }

        fun convert(professorDTO: ProfessorDTO): Professor {
            val professor = Professor(
                professorDTO.id,
                professorDTO.firstName,
                professorDTO.surName
            )

            professor.middleName = professorDTO.middleName ?: ""
            professor.email = professorDTO.email ?: ""

            return professor
        }

        fun convertToEntity(professorDTO: ProfessorDTO): ProfessorEntity {
            val professorEntity = ProfessorEntity(
                professorDTO.id,
                professorDTO.firstName,
                professorDTO.surName
            )

            professorEntity.email = professorDTO.email
            professorEntity.middleName = professorDTO.middleName

            return professorEntity
        }
    }
}