package com.gwsf.appfornstu.presentation.internal.di.component.listdisciplines

import com.gwsf.appfornstu.presentation.feature.listdiscipline.view.ListDisciplinesFragment
import com.gwsf.appfornstu.presentation.internal.di.ScreenScope
import com.gwsf.appfornstu.presentation.internal.di.component.AppComponent
import dagger.Component

@ScreenScope
@Component(dependencies = [AppComponent::class, ListDisciplinesComponent::class])
interface ListDisciplineScreenComponent {

    fun inject(listDisciplinesFragment: ListDisciplinesFragment)
}