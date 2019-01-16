package com.nstu.data.user.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey
    val id: Int,
    val email: String,
    val password: String,
    val firstName: String,
    val secondName: String,
    val middleName: String
)
