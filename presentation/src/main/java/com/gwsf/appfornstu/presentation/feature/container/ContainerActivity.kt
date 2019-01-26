package com.gwsf.appfornstu.presentation.feature.container

import android.os.Bundle
import com.gwsf.appfornstu.presentation.R
import com.gwsf.appfornstu.presentation.feature.BaseActivity

class ContainerActivity: BaseActivity<ContainerView>(), ContainerView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_container)

    }
}