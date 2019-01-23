package com.gwsf.appfornstu.feature.lesson.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LessonViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LessonViewModel() as T
    }

}
