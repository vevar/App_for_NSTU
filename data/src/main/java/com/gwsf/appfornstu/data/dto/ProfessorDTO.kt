package com.gwsf.appfornstu.data.dto

data class ProfessorDTO(
    val id: Int,
    val firstName: String,
    val surName: String
) {
    var email: String? = null
    var password: String? = null
    var middleName: String? = null
}