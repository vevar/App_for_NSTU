package com.nstu.domain.interactor

import com.nstu.domain.executor.ExecutorThread
import com.nstu.domain.executor.PostExecutorThread
import com.nstu.domain.model.timetable.TimeTable
import com.nstu.domain.repository.TimeTableRepository
import io.reactivex.Maybe

class GetTimeTableCase(
    val timeTableRepository: TimeTableRepository,
    executorThread: ExecutorThread,
    postExecutorThread: PostExecutorThread
) :
    UseCase<TimeTable, GetTimeTableCase.Companion.Params>(
        executorThread,
        postExecutorThread
    ) {
    override fun buildUseCaseObservable(params: Params): Maybe<TimeTable> {
        return timeTableRepository.findByUserId(params.userId)
    }

    companion object {
        class Params(val userId: Int) {

            fun forUser(userId: Int): Params {
                return Params(userId)
            }
        }
    }
}