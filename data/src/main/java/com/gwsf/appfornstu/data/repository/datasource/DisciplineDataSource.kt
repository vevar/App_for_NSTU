package com.gwsf.appfornstu.data.repository.datasource

import com.gwsf.appfornstu.data.dto.DisciplineDTO
import io.reactivex.Completable
import io.reactivex.Maybe

interface DisciplineDataSource {

    fun getListDisciplinesByUserId(userId: Int): Maybe<List<DisciplineDTO>>

    fun postListDisciplines(listDisciplines: List<DisciplineDTO>): Completable
}