package com.gwsf.appfornstu.presentation.internal.di.component.listdisciplines

import com.gwsf.appfornstu.presentation.internal.di.module.dao.DaoModule
import com.gwsf.appfornstu.presentation.internal.di.module.datasource.DisciplineSourceModule
import com.gwsf.appfornstu.presentation.internal.di.module.repository.DisciplineRepositoryModule
import com.gwsf.domain.repository.concrete.DisciplineRepository
import dagger.Component

@Component(
    modules = [DisciplineSourceModule::class, DisciplineRepositoryModule::class, DaoModule::class]
)
interface ListDisciplinesComponent {

    fun disciplineRepository(): DisciplineRepository

}