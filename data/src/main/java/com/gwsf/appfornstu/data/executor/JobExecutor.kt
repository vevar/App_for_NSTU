package com.gwsf.appfornstu.data.executor

import com.gwsf.domain.executor.ExecutorThread
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JobExecutor @Inject constructor() : ExecutorThread {

    private val threadPoolExecutor: ThreadPoolExecutor = ThreadPoolExecutor(
        3, 5, 10, TimeUnit.SECONDS,
        LinkedBlockingQueue(), JobThreadFactory()
    )

    override fun execute(runnable: Runnable?) {
        threadPoolExecutor.execute(runnable)
    }

    private class JobThreadFactory : ThreadFactory {

        private var counter: Int = 0

        override fun newThread(runnable: Runnable?): Thread {
            return Thread(runnable, "android_thread_#${counter++}")
        }

    }
}