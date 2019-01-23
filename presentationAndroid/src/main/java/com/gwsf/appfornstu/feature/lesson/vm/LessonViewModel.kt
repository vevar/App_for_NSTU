package com.gwsf.appfornstu.feature.lesson.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LessonViewModel : ViewModel() {

    val disciplineName: MutableLiveData<String> = MutableLiveData()
    val professor: MutableLiveData<String> = MutableLiveData()
    val location: MutableLiveData<String> = MutableLiveData()
    val time: MutableLiveData<String> = MutableLiveData()

}
