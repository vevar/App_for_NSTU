package com.gwsf.appfornstu.presentation.feature.lesson.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.gwsf.appfornstu.presentation.R
import com.gwsf.appfornstu.presentation.databinding.ActivityLessonBinding
import com.gwsf.appfornstu.presentation.feature.lesson.vm.LessonViewModel
import com.gwsf.appfornstu.presentation.feature.lesson.vm.LessonViewModelFactory

class LessonActivity : AppCompatActivity(), LessonView {

    private lateinit var mLessonViewModel: LessonViewModel

    private lateinit var mBinding: ActivityLessonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_lesson)

        mLessonViewModel = ViewModelProviders.of(
            this,
            LessonViewModelFactory()
        ).get(LessonViewModel::class.java)

    }
}
