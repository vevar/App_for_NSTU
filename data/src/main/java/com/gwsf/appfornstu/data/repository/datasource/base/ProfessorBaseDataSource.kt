package com.gwsf.appfornstu.data.repository.datasource.base

import com.gwsf.appfornstu.data.dto.ProfessorDTO
import com.gwsf.appfornstu.data.repository.datasource.ProfessorDataSource
import com.gwsf.appfornstu.data.repository.datasource.base.dao.ProfessorDao
import com.gwsf.appfornstu.data.util.mapper.ProfessorMapper
import io.reactivex.Completable
import javax.inject.Inject

class ProfessorBaseDataSource @Inject constructor(
    private val professorDao: ProfessorDao
) : ProfessorDataSource {

    override fun saveAll(listProfessorsDTO: List<ProfessorDTO>): Completable {
        return professorDao.saveAll(listProfessorsDTO.map {
            ProfessorMapper.convertToEntity(it)
        })
    }

    override fun save(professorDTO: ProfessorDTO): Completable {
        return professorDao.save(ProfessorMapper.convertToEntity(professorDTO))
    }

}