package com.gwsf.appfornstu.feature.container

import android.os.Bundle
import com.gwsf.appfornstu.R
import com.gwsf.appfornstu.feature.BaseActivity

class ContainerActivity: BaseActivity<ContainerView>(), ContainerView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_container)

    }
}