package com.gwsf.appfornstu.feature.discipline.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gwsf.domain.interactor.GetListDisciplinesCase
import com.gwsf.domain.model.discipline.Discipline
import com.gwsf.domain.model.user.Professor
import io.reactivex.observers.DisposableObserver
import java.util.*

class DisciplineViewModel(
    val userId: Int
) : ViewModel() {

    lateinit var getListDisciplinesCase: GetListDisciplinesCase

    val listDiscipline: MutableLiveData<List<Discipline>> = MutableLiveData(listOf())

    fun loadListDisciplines() {
        val mutableListOf: MutableList<Discipline> = mutableListOf()
        mutableListOf.add(Discipline(1, "Интеллектуальные системы и технологии", Collections.singletonList(Professor(1,"asd","asd,", "Vasy","Pyplin","asdf"))))
        mutableListOf.add(Discipline(1, "Интеллектуальные системы и технологии", Collections.singletonList(Professor(1,"asd","asd,", "Vasy","Pyplin","asdf"))))
        mutableListOf.add(Discipline(1, "Интеллектуальные системы и технологии", Collections.singletonList(Professor(1,"asd","asd,", "Vasy","Pyplin","asdf"))))
        mutableListOf.add(Discipline(1, "Интеллектуальные системы и технологии", Collections.singletonList(Professor(1,"asd","asd,", "Vasy","Pyplin","asdf"))))
        mutableListOf.add(Discipline(1, "Интеллектуальные системы и технологии", Collections.singletonList(Professor(1,"asd","asd,", "Vasy","Pyplin","asdf"))))
        mutableListOf.add(Discipline(1, "Интеллектуальные системы и технологии", Collections.singletonList(Professor(1,"asd","asd,", "Vasy","Pyplin","asdf"))))
        mutableListOf.add(Discipline(1, "Интеллектуальные системы и технологии", Collections.singletonList(Professor(1,"asd","asd,", "Vasy","Pyplin","asdf"))))
        mutableListOf.add(Discipline(1, "Интеллектуальные системы и технологии", Collections.singletonList(Professor(1,"asd","asd,", "Vasy","Pyplin","asdf"))))
        mutableListOf.add(Discipline(1, "Интеллектуальные системы и технологии", Collections.singletonList(Professor(1,"asd","asd,", "Vasy","Pyplin","asdf"))))
        mutableListOf.add(Discipline(1, "Интеллектуальные системы и технологии", Collections.singletonList(Professor(1,"asd","asd,", "Vasy","Pyplin","asdf"))))
        mutableListOf.add(Discipline(1, "Интеллектуальные системы и технологии", Collections.singletonList(Professor(1,"asd","asd,", "Vasy","Pyplin","asdf"))))
        mutableListOf.add(Discipline(1, "Интеллектуальные системы и технологии", Collections.singletonList(Professor(1,"asd","asd,", "Vasy","Pyplin","asdf"))))
        mutableListOf.add(Discipline(1, "Интеллектуальные системы и технологии", Collections.singletonList(Professor(1,"asd","asd,", "Vasy","Pyplin","asdf"))))
        mutableListOf.add(Discipline(1, "Интеллектуальные системы и технологии", Collections.singletonList(Professor(1,"asd","asd,", "Vasy","Pyplin","asdf"))))
        mutableListOf.add(Discipline(1, "Интеллектуальные системы и технологии", Collections.singletonList(Professor(1,"asd","asd,", "Vasy","Pyplin","asdf"))))
        mutableListOf.add(Discipline(1, "Интеллектуальные системы и технологии", Collections.singletonList(Professor(1,"asd","asd,", "Vasy","Pyplin","asdf"))))
        mutableListOf.add(Discipline(1, "Интеллектуальные системы и технологии", Collections.singletonList(Professor(1,"asd","asd,", "Vasy","Pyplin","asdf"))))
        mutableListOf.add(Discipline(1, "Интеллектуальные системы и технологии", Collections.singletonList(Professor(1,"asd","asd,", "Vasy","Pyplin","asdf"))))

        listDiscipline.value = mutableListOf

//        getListDisciplinesCase.execute(object : DisposableObserver<List<Discipline>>() {
//            override fun onComplete() {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onNext(list: List<Discipline>) {
//                listDiscipline.value = list
//            }
//
//            override fun onError(e: Throwable) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//        }, GetListDisciplinesCase.Companion.Params.forUser(userId))
    }
}