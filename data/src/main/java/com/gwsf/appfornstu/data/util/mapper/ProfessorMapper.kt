package com.gwsf.appfornstu.data.util.mapper

import com.gwsf.appfornstu.data.dto.ProfessorDTO
import com.gwsf.domain.model.user.Professor

class ProfessorMapper {
    companion object {
        fun convert(professorDTO: ProfessorDTO): Professor {
            return Professor(
                professorDTO.id,
                professorDTO.firstName,
                professorDTO.secondName,
                professorDTO.middleName
            )
        }
    }
}