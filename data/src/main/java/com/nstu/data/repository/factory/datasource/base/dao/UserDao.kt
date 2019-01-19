package com.nstu.data.repository.factory.datasource.base.dao

import com.nstu.data.entity.UserEntity
import io.reactivex.Completable

interface UserDao {
    fun save(userEntity: UserEntity): Completable
}