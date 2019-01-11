package com.alxminyaev.nstuplanner.presenter.feature.login.view

import com.alxminyaev.app_for_nstu.feature.MVVMView

interface LoginView : MVVMView {
    fun showProgressBar()

    fun hideProgressBar()
}