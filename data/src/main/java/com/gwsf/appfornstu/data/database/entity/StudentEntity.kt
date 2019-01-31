package com.gwsf.appfornstu.data.database.entity

import androidx.room.Entity

@Entity
data class StudentEntity(
    val id: Int,
    val email: String,
    val password: String,
    val firstName: String,
    val surName: String
){
    lateinit var middleName: String

}
