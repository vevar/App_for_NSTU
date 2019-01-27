package com.gwsf.appfornstu.data.util.mapper

import com.gwsf.appfornstu.data.database.entity.DisciplineEntity
import com.gwsf.appfornstu.data.dto.DisciplineDTO

class DisciplineMapper {
    companion object {
        fun convert(disciplineEntity: DisciplineEntity): DisciplineDTO {
            return DisciplineDTO(
                disciplineEntity.id,
                disciplineEntity.name
            )
        }
    }
}