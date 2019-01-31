package com.gwsf.appfornstu.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = ProfessorEntity.TABLE_NAME)
class ProfessorEntity(
    @PrimaryKey
    @ColumnInfo(name = "uid")
    val id: Int,
    val firstName: String,
    val surName: String
) {
    var email: String? = null
    var middleName: String? = null

    companion object {
        const val TABLE_NAME = "professor"
    }
}
