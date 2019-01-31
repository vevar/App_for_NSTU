package com.gwsf.appfornstu.presentation.feature.listdiscipline.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gwsf.domain.interactor.GetListDisciplinesCase
import javax.inject.Inject

class ListDisciplineViewModelFactory
@Inject constructor(private val getListDisciplinesCase: GetListDisciplinesCase) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListDisciplineViewModel::class.java)) {
            return ListDisciplineViewModel(getListDisciplinesCase) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}