package com.gwsf.appfornstu.data.repository.factory.datasource

import com.gwsf.appfornstu.data.dto.DisciplineDTO
import com.gwsf.domain.model.discipline.Discipline
import io.reactivex.Completable
import io.reactivex.Maybe

interface DisciplineDataSource {

    fun getListDisciplinesByUserId(userId: Int): Maybe<List<DisciplineDTO>>

    fun postListDisciplines(listDisciplines: List<DisciplineDTO>): Completable
}