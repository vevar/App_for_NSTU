package com.nstu.domain.model.user

abstract class User(
    val id: Int,
    val email: String,
    val password: String,
    val firstName: String,
    val secondName: String,
    val middleName: String
)