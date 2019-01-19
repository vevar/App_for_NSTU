package com.nstu.data.repository.factory.datasource.base.dao

import com.nstu.data.entity.DisciplineEntity
import io.reactivex.Completable

interface DisciplineDao {

    fun save(disciplineEntity: DisciplineEntity): Completable

}