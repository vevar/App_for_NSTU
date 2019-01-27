package com.gwsf.appfornstu.data.executor

import com.gwsf.domain.executor.ExecutorThread
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JobExecutor @Inject constructor() : ExecutorThread {
    override fun execute(command: Runnable?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}