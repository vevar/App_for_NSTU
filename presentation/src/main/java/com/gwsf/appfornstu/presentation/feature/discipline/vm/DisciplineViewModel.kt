package com.gwsf.appfornstu.presentation.feature.discipline.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.gwsf.domain.interactor.GetListDisciplinesCase
import com.gwsf.domain.model.discipline.Discipline
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class DisciplineViewModel @Inject constructor(
    private val getListDisciplinesCase: GetListDisciplinesCase
) : ViewModel() {

    var userId: Int = -1

    var mSearchedDiscipline: MutableLiveData<String> = MutableLiveData("")

    private val mSearchObserver: Observer<String> = Observer {
        if (it.isEmpty()) {
            mVisibleListDiscipline.value = mListDiscipline.value
        } else {
            mVisibleListDiscipline.value = mListDiscipline.value!!.filter { discipline ->
                discipline.name.contains(it, true)
            }
        }
    }


    private val mListDiscipline: MutableLiveData<List<Discipline>> = MutableLiveData(listOf())
    val mVisibleListDiscipline: MutableLiveData<List<Discipline>> = MutableLiveData(listOf())

    init {
        mSearchedDiscipline.observeForever(mSearchObserver)
        mListDiscipline.observeForever {
            mVisibleListDiscipline.value = mListDiscipline.value
        }
    }

    fun init(userId: Int) {
        this.userId = userId
    }

    fun loadListDisciplines() {
        getListDisciplinesCase.execute(object : DisposableObserver<List<Discipline>>() {
            override fun onComplete() {

            }

            override fun onNext(list: List<Discipline>) {
                mListDiscipline.value = list.sortedBy {
                    it.name
                }
            }

            override fun onError(e: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }, GetListDisciplinesCase.Companion.Params.forUser(userId))
    }
}