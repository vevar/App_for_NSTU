package com.alxminyaev.appfornstu.feature.login.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nstu.domain.model.user.User


class LoginViewModel : ViewModel() {

    val login: MutableLiveData<String> = MutableLiveData()
    var loginFlag = false

    val password: MutableLiveData<String> = MutableLiveData()
    var passwordFlag = false

    var isInputDataCorrect: MutableLiveData<Boolean> = MutableLiveData()
    var userModel: User? = null
    var isNew: Boolean = true

}