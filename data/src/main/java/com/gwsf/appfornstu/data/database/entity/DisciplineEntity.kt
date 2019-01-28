package com.gwsf.appfornstu.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = DisciplineEntity.TABLE_NAME)
data class DisciplineEntity(
    @PrimaryKey
    @ColumnInfo(name = "uid")
    val uid: Int,
    val name: String
) {
    companion object {
        const val TABLE_NAME = "discipline"
    }
}