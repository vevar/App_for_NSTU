package com.gwsf.appfornstu.data.repository

import com.gwsf.appfornstu.data.repository.factory.datasource.DisciplineDataSource
import com.gwsf.appfornstu.data.util.mapper.DisciplineMapper
import com.gwsf.domain.model.discipline.Discipline
import com.gwsf.domain.repository.concrete.DisciplineRepository
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named


class DisciplineRepositoryBC @Inject constructor(
    @Named("Base")
    val disciplineBaseDataSource: dagger.Lazy<DisciplineDataSource>,
    @Named("Cloud")
    val disciplineCloudDataSource: dagger.Lazy<DisciplineDataSource>
) : DisciplineRepository {


    override fun findDisciplineByUserId(userId: Int): Single<Discipline> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findListDisciplinesByUserId(userId: Int): Observable<List<Discipline>> {
        val base = disciplineBaseDataSource.get().getListDisciplinesByUserId(userId)
        val cloud = disciplineCloudDataSource.get().getListDisciplinesByUserId(userId)
            .doOnSuccess { list ->
                disciplineBaseDataSource.get().postListDisciplines(list)
                    .subscribe()

            }

        return Observable.merge(base.toObservable(), cloud.toObservable()).map {
            it.map { disciplineDTO ->
                DisciplineMapper.convert(disciplineDTO)
            }
        }
    }
}