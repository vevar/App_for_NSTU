package com.gwsf.appfornstu.data.database.entity

import androidx.room.Entity

@Entity
data class DisciplineMtoMUser(
    val disciplineId: Int,
    val userId: Int
)