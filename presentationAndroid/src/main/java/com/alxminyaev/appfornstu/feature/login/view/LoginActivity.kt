package com.alxminyaev.appfornstu.feature.login.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import com.alxminyaev.appfornstu.R
import com.alxminyaev.appfornstu.databinding.ActivityLoginBinding
import com.alxminyaev.appfornstu.feature.BaseActivity
import com.alxminyaev.appfornstu.feature.login.vm.LoginViewModel
import com.alxminyaev.appfornstu.feature.login.vm.LoginViewModelFactory


class LoginActivity : BaseActivity<LoginView>(), LoginView {

    companion object {
        private const val STATE_LOGIN = "login"
        private const val STATE_PASSWORD = "password"
    }

    private lateinit var mLoginModel: LoginViewModel

    private lateinit var mBinding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBindingAndLoginModel()
    }

    private fun initBindingAndLoginModel() {
        mBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_login
        )
        mLoginModel = ViewModelProviders.of(
            this,
            LoginViewModelFactory()
        )
            .get(LoginViewModel::class.java)

        mBinding.loginModel = mLoginModel

        mBinding.buttonLogin.setOnClickListener {
            mLoginModel.login.value = mBinding.editTextLogin.text.toString()
            mLoginModel.password.value = mBinding.editTextPassword.text.toString()

            if (mLoginModel.loginFlag && mLoginModel.passwordFlag) {
                mBinding.buttonLogin.isEnabled = false
                mLoginModel.isInputDataCorrect.value = true

                if (mLoginModel.userModel != null) {
                    TODO()
//                    ContainerActivity.startActivityDayTimeTable(this@LoginActivity)
                } else {
                    mBinding.buttonLogin.isEnabled = true
                }

                hideProgressBar()
            }
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (mLoginModel.isNew) {
            mLoginModel.login.value = savedInstanceState?.getString(STATE_LOGIN)
            mLoginModel.password.value = savedInstanceState?.getString(STATE_PASSWORD)
        }

        mBinding.editTextLogin.setText(mLoginModel.login.value)
        mBinding.editTextPassword.setText(mLoginModel.password.value)
    }


    override fun onResume() {
        super.onResume()

        mLoginModel.login.observe(this, Observer<String> { login ->
            val regexMail = ".+@.*nstu.ru".toRegex()

            if (login == null || login.isEmpty()) {
                mBinding.textViewInfoLogin.text = getString(R.string.text_input_login)
                mBinding.textViewInfoLogin.visibility = TextView.VISIBLE

                mLoginModel.loginFlag = false
            } else if (!regexMail.containsMatchIn(login)) {
                mBinding.textViewInfoLogin.text = getString(R.string.text_contain_nstu_ru)
                mBinding.textViewInfoLogin.visibility = TextView.VISIBLE

                mLoginModel.loginFlag = false
            } else {
                mBinding.textViewInfoLogin.text = ""
                mBinding.textViewInfoLogin.visibility = TextView.GONE

                mLoginModel.loginFlag = true
            }
        })

        mLoginModel.password.observe(this, Observer<String> { password ->
            if (password == null || password.isEmpty()) {
                mBinding.textViewInfoPassword.text = getString(R.string.text_input_password)
                mBinding.textViewInfoPassword.visibility = TextView.VISIBLE

                mLoginModel.passwordFlag = false
            } else {
                mBinding.textViewInfoPassword.text = ""
                mBinding.textViewInfoPassword.visibility = TextView.GONE

                mLoginModel.passwordFlag = true
            }
        })

        mLoginModel.isInputDataCorrect.observe(this, Observer {
            if (it != null && it) {
                showProgressBar()
            }
        })
    }

    override fun onPause() {
        super.onPause()

        mLoginModel.login.removeObservers(this)
        mLoginModel.password.removeObservers(this)

        mLoginModel.login.value = mBinding.editTextLogin.text.toString()
        mLoginModel.password.value = mBinding.editTextPassword.text.toString()

        mLoginModel.isNew = false
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.run {
            putString(STATE_LOGIN, mBinding.editTextLogin.text.toString())
            putString(STATE_PASSWORD, mBinding.editTextPassword.text.toString())
        }
    }


    override fun showProgressBar() {
        mBinding.progressBar.visibility = ProgressBar.VISIBLE
    }

    override fun hideProgressBar() {
        mBinding.progressBar.visibility = ProgressBar.GONE
    }
}
