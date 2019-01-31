package com.gwsf.appfornstu.data.dto

class DisciplineDTO(
    val id: Int,
    val name: String
) {
    lateinit var mainProfessorDTO: ProfessorDTO
}
