package com.gwsf.appfornstu.presentation.internal.di.component.listevents

import com.gwsf.appfornstu.presentation.feature.listevent.view.ListEventFragment
import com.gwsf.appfornstu.presentation.internal.di.ScreenScope
import com.gwsf.appfornstu.presentation.internal.di.component.AppComponent
import dagger.Component


@ScreenScope
@Component(
    dependencies = [AppComponent::class, ListEventsComponent::class]
)
interface ListEventsScreenComponent {

    fun inject(listEventsFragment: ListEventFragment)

}