package com.gwsf.appfornstu.presentation.feature.container

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.gwsf.appfornstu.presentation.R
import com.gwsf.appfornstu.presentation.feature.BaseActivity

class ContainerActivity : BaseActivity<ContainerView>(), ContainerView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_container)

    }

    companion object {

        private const val EXTRA_USER_ID = "EXTRA_USER_LOGIN"
        private const val EXTRA_USER_LOGIN = "EXTRA_USER_LOGIN"

        fun startActivityContainer(activity: Activity, userId: Int, login: String) {
            val intentToStartActivity = Intent(activity, ContainerActivity::class.java)
            intentToStartActivity.putExtra(EXTRA_USER_ID, userId)
            intentToStartActivity.putExtra(EXTRA_USER_LOGIN, login)
            activity.startActivity(intentToStartActivity)

        }
    }
}