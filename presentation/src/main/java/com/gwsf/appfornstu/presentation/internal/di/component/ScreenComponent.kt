package com.gwsf.appfornstu.presentation.internal.di.component

import com.gwsf.appfornstu.presentation.feature.discipline.view.DisciplineFragment
import com.gwsf.appfornstu.presentation.internal.di.ScreenScope
import com.gwsf.appfornstu.presentation.internal.di.module.ViewModelModule
import dagger.Component

@ScreenScope
@Component(dependencies = [AppComponent::class])
interface ScreenComponent {

    fun inject(disciplineFragment: DisciplineFragment)

}