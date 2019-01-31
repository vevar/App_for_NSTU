package com.gwsf.appfornstu.data.repository

import com.gwsf.appfornstu.data.repository.datasource.DisciplineDataSource
import com.gwsf.appfornstu.data.util.mapper.DisciplineMapper
import com.gwsf.domain.model.discipline.Discipline
import com.gwsf.domain.repository.concrete.DisciplineRepository
import dagger.Lazy
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named


class DisciplineRepositoryBC @Inject constructor(
    @Named("Base")
    val disciplineBaseDataSource: Lazy<DisciplineDataSource>,
    @Named("Cloud")
    val disciplineCloudDataSource: Lazy<DisciplineDataSource>
) : DisciplineRepository {


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