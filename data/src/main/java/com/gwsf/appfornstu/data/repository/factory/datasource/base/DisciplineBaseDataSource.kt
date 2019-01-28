package com.gwsf.appfornstu.data.repository.factory.datasource.base

import com.gwsf.appfornstu.data.dto.DisciplineDTO
import com.gwsf.appfornstu.data.repository.factory.datasource.DisciplineDataSource
import com.gwsf.appfornstu.data.repository.factory.datasource.base.dao.DisciplineDao
import com.gwsf.appfornstu.data.util.mapper.DisciplineMapper
import io.reactivex.Maybe
import javax.inject.Inject

class DisciplineBaseDataSource @Inject constructor(
    private val disciplineDao: DisciplineDao
) : DisciplineDataSource {

    override fun getListDisciplinesByUserId(userId: Int): Maybe<List<DisciplineDTO>> {
        return disciplineDao.getDisciplinesById(userId).map {
            it.map { disciplineEntity ->
                DisciplineMapper.convert(disciplineEntity)
            }
        }
    }
}