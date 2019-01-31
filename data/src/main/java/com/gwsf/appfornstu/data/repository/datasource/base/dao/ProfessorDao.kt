package com.gwsf.appfornstu.data.repository.datasource.base.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gwsf.appfornstu.data.database.entity.ProfessorEntity
import io.reactivex.Completable
import io.reactivex.Maybe

@Dao
interface ProfessorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(professorEntity: ProfessorEntity): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(listProfessorsEntity: List<ProfessorEntity>): Completable

    @Query("SELECT * FROM professor WHERE uid LIKE :professorId")
    fun getById(professorId: Int): Maybe<ProfessorEntity>
}