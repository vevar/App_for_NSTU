package com.nstu.domain.model.discipline

import com.nstu.domain.model.user.Professor

data class Discipline(
    val id: Int,
    val name: String,
    val listLessons: List<Lesson>,
    val listProfessors: List<Professor>
)