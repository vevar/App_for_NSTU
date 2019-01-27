package com.gwsf.appfornstu.data.repository

import com.gwsf.domain.model.discipline.Discipline
import com.gwsf.domain.repository.concrete.DisciplineRepository
import io.reactivex.Single
import javax.inject.Inject


class DisciplineRepositoryBC @Inject constructor(): DisciplineRepository {

    override fun findDisciplineByUserId(userId: Int): Single<Discipline> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findListDisciplinesByUserId(userId: Int): Single<List<Discipline>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}