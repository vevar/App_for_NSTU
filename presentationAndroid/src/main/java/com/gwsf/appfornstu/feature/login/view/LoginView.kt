package com.gwsf.appfornstu.feature.login.view

import com.gwsf.appfornstu.feature.MVVMView

interface LoginView : MVVMView {
    fun showProgressBar()

    fun hideProgressBar()
}