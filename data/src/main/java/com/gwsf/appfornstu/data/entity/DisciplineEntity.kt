package com.gwsf.appfornstu.data.entity

data class DisciplineEntity(
    val id: Int,
    val name: String,
    val listLessonsIds: List<Int>,
    val listProfessorsIds: List<Int>
)