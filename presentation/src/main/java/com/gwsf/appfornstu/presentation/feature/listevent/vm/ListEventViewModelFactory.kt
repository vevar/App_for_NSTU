package com.gwsf.appfornstu.presentation.feature.listevent.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class ListEventViewModelFactory @Inject constructor() : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListEvenViewModel::class.java)) {
            return ListEvenViewModel() as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}