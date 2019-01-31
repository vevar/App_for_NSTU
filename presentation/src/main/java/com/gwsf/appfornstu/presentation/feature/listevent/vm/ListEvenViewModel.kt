package com.gwsf.appfornstu.presentation.feature.listevent.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gwsf.domain.model.event.Event

class ListEvenViewModel : ViewModel() {

    val mListEvents: MutableLiveData<List<Event>> = MutableLiveData(listOf())

    fun loadListEvents() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}