package com.nstu.data.repository.factory.datasource.base.dao

import com.nstu.data.entity.LessonEntity
import io.reactivex.Completable

interface LessonDao {

    fun saveAll(listLesson: List<LessonEntity>): Completable
}