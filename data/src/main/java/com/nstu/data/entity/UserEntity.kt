package com.nstu.data.entity

data class UserEntity(
    val id: Int,
    val firstName: String,
    val secondName: String,
    val middleName: String,
    val type: String
) {
    lateinit var email: String

}
