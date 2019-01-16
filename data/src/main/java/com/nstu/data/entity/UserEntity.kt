package com.nstu.data.entity

data class UserEntity(
    val id: Int,
    val email: String,
    val password: String,
    val firstName: String,
    val secondName: String,
    val middleName: String,
    val type: String
)
