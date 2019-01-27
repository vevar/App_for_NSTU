package com.gwsf.appfornstu.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DisciplineEntity(
    @PrimaryKey
    val id: Int,
    val name: String
) {
    companion object {
        const val TABLE_NAME = "discipline"
    }
}