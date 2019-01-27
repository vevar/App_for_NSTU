package com.gwsf.appfornstu.data.repository

import com.gwsf.appfornstu.data.repository.factory.datasource.DisciplineDataSource
import com.gwsf.domain.model.discipline.Discipline
import com.gwsf.domain.repository.concrete.DisciplineRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named


class DisciplineRepositoryBC @Inject constructor(
    @Named("Base")
    disciplineBaseDataSource: DisciplineDataSource
) : DisciplineRepository {

    override fun findDisciplineByUserId(userId: Int): Single<Discipline> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findListDisciplinesByUserId(userId: Int): Single<List<Discipline>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}