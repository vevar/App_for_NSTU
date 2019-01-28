package com.gwsf.appfornstu.data.dto

data class ProfessorDTO(
    val id: Int,
    val firstName: String,
    val secondName: String,
    val middleName: String
) {
    lateinit var email: String
    lateinit var password: String
}