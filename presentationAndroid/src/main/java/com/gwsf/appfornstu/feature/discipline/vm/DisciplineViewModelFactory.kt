package com.gwsf.appfornstu.feature.discipline.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DisciplineViewModelFactory(private val userId: Int) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DisciplineViewModel::class.java)) {
            return DisciplineViewModel(userId) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}