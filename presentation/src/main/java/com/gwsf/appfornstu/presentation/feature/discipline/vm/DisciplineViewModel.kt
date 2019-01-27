package com.gwsf.appfornstu.presentation.feature.discipline.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gwsf.domain.interactor.GetListDisciplinesCase
import com.gwsf.domain.model.discipline.Discipline
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class DisciplineViewModel @Inject constructor(
    private val getListDisciplinesCase: GetListDisciplinesCase
) : ViewModel() {

    var userId: Int = -1

    val listDiscipline: MutableLiveData<List<Discipline>> = MutableLiveData(listOf())

    fun init(userId: Int) {
        this.userId = userId
    }

    fun loadListDisciplines() {
        val mutableListOf: MutableList<Discipline> = mutableListOf()

        listDiscipline.value = mutableListOf

        getListDisciplinesCase.execute(object : DisposableObserver<List<Discipline>>() {
            override fun onComplete() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onNext(list: List<Discipline>) {
                listDiscipline.value = list
            }

            override fun onError(e: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }, GetListDisciplinesCase.Companion.Params.forUser(userId))
    }
}