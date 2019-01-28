package com.gwsf.appfornstu.data.util.mapper

import com.gwsf.appfornstu.data.database.entity.DisciplineEntity
import com.gwsf.appfornstu.data.dto.DisciplineDTO
import com.gwsf.domain.model.discipline.Discipline

class DisciplineMapper {
    companion object {
        fun convert(disciplineEntity: DisciplineEntity): DisciplineDTO {
            return DisciplineDTO(
                disciplineEntity.uid,
                disciplineEntity.name
            )
        }

        fun convert(disciplineDTO: DisciplineDTO)
                : Discipline {
            return Discipline(
                disciplineDTO.id,
                disciplineDTO.name
            )
        }
    }
}