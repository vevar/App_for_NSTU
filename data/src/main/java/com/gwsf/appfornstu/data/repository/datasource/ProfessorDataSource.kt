package com.gwsf.appfornstu.data.repository.datasource

import com.gwsf.appfornstu.data.dto.ProfessorDTO
import io.reactivex.Completable

interface ProfessorDataSource {

    fun save(professorDTO: ProfessorDTO): Completable

    fun saveAll(listProfessorsDTO: List<ProfessorDTO>): Completable
}