package com.gwsf.appfornstu.presentation.feature.login.view

import com.gwsf.appfornstu.presentation.feature.MVVMView

interface LoginView : MVVMView {
    fun showProgressBar()

    fun hideProgressBar()
}