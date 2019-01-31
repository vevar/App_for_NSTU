package com.gwsf.appfornstu.presentation.feature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gwsf.appfornstu.presentation.App

abstract class BaseActivity<T : MVVMView> : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        App.getApp(this).getApplicationComponent()
    }

    fun addFragment(containerId: Int, baseFragment: BaseFragment): Int {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(containerId, baseFragment)
        return transaction.commit()
    }
}