package com.nstu.data.repository.factory.datasource.base

import com.nstu.data.entity.LessonEntity
import io.reactivex.Completable

interface LessonBaseDataSource {
    fun saveAll(listLessonEntity: List<LessonEntity>): Completable
}