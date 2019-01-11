package com.alxminyaev.app_for_nstu.feature.login.vm

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class LoginViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel() as T
    }

}