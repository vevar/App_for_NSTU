package com.gwsf.appfornstu.data.repository.factory.datasource.base.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gwsf.appfornstu.data.database.entity.DisciplineEntity
import io.reactivex.Completable
import io.reactivex.Maybe

@Dao
interface DisciplineDao {
    @Query("SELECT * FROM ${DisciplineEntity.TABLE_NAME} WHERE uid LIKE :userId")
    fun getDisciplinesById(userId: Int): Maybe<List<DisciplineEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(listDisciplines: List<DisciplineEntity>) :Completable
}