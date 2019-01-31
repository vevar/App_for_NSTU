package com.gwsf.appfornstu.data.repository.datasource.base

import com.gwsf.appfornstu.data.dto.DisciplineDTO
import com.gwsf.appfornstu.data.dto.ProfessorDTO
import com.gwsf.appfornstu.data.repository.datasource.DisciplineDataSource
import com.gwsf.appfornstu.data.repository.datasource.base.dao.DisciplineDao
import com.gwsf.appfornstu.data.repository.datasource.base.dao.ProfessorDao
import com.gwsf.appfornstu.data.util.mapper.DisciplineMapper
import com.gwsf.appfornstu.data.util.mapper.ProfessorMapper
import dagger.Lazy
import io.reactivex.Completable
import io.reactivex.Maybe
import javax.inject.Inject

class DisciplineBaseDataSource @Inject constructor(
    private val disciplineDao: DisciplineDao,
    private val professorDao: Lazy<ProfessorDao>
) : DisciplineDataSource {


    override fun getListDisciplinesByUserId(userId: Int): Maybe<List<DisciplineDTO>> {
        return disciplineDao.getDisciplinesByUserId(userId).map {
            val professors: MutableList<ProfessorDTO> = mutableListOf()

            val disciplines: List<DisciplineDTO> = it.map { disciplineEntity ->
                professorDao.get().getById(disciplineEntity.idMainProfessor)
                    .map { professorEntity ->
                        ProfessorMapper.convert(professorEntity)
                    }.doOnSuccess { professorDTO ->
                        professors.add(professorDTO)
                    }.subscribe()

                DisciplineMapper.convert(disciplineEntity)
            }

            disciplines.zip(
                professors
            ) { discipline, professor ->
                discipline.mainProfessorDTO = professor
                discipline
            }

        }
    }

    override fun postListDisciplines(listDisciplines: List<DisciplineDTO>): Completable {
        val listDisciplinesEntity = listDisciplines.map {
            DisciplineMapper.convertToEntity(it)
        }

        val listProfessorEntity = listDisciplines.map {
            ProfessorMapper.convertToEntity(it.mainProfessorDTO)
        }

        professorDao.get().saveAll(listProfessorEntity)

        return disciplineDao.saveAll(listDisciplinesEntity)
    }

}