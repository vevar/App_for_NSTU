package com.alxminyaev.app_for_nstu.feature.login.vm

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.nstu.domain.model.User


class LoginViewModel : ViewModel() {

    val login: MutableLiveData<String> = MutableLiveData()
    var loginFlag = false

    val password: MutableLiveData<String> = MutableLiveData()
    var passwordFlag = false

    var isInputDataCorrect: MutableLiveData<Boolean> = MutableLiveData()
    var userModel: User? = null
    var isNew: Boolean = true
//
}