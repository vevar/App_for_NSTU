package com.nstu.domain.interactor

import com.nstu.domain.executor.ExecutorThread
import com.nstu.domain.executor.PostExecutorThread
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

abstract class UseCase<T, Params>(
    private val executorThread: ExecutorThread,
    private val postExecutorThread: PostExecutorThread
) {

    private val disposables: CompositeDisposable = CompositeDisposable()

    abstract fun buildUseCaseObservable(params: Params): Observable<T>

    fun execute(observer: DisposableObserver<T>, params: Params) {
        val observable: Observable<T> = buildUseCaseObservable(params)
            .subscribeOn(Schedulers.from(executorThread))
            .observeOn(postExecutorThread.getScheduler())

        addDisposable(disposables)
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

}