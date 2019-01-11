package com.alxminyaev.appfornstu.feature.login.view

import com.alxminyaev.appfornstu.feature.MVVMView

interface LoginView : MVVMView {
    fun showProgressBar()

    fun hideProgressBar()
}