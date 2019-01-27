package com.gwsf.appfornstu.data.repository.factory.datasource

import com.gwsf.appfornstu.data.dto.DisciplineDTO
import io.reactivex.Maybe

interface DisciplineDataSource {

    fun getListDisciplinesByUserId(userId: Int): Maybe<List<DisciplineDTO>>

}