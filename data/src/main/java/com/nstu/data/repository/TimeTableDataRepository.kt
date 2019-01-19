package com.nstu.data.repository

import com.nstu.data.repository.factory.DayDataSourceFactory
import com.nstu.data.repository.factory.LessonDataSourceFactory
import com.nstu.data.repository.factory.TimeTableDataSourceFactory
import com.nstu.data.repository.factory.datasource.cloud.dto.DayDTO
import com.nstu.data.repository.factory.datasource.cloud.dto.LessonDTO
import com.nstu.data.repository.factory.datasource.cloud.dto.TimeTableDTO
import com.nstu.data.util.mapper.*
import com.nstu.domain.model.timetable.TimeTable
import com.nstu.domain.repository.TimeTableRepository
import io.reactivex.Maybe

class TimeTableDataRepository : TimeTableRepository {

    private lateinit var timeTableFactory: TimeTableDataSourceFactory
    private lateinit var dayFactory: DayDataSourceFactory
    private lateinit var lessonFactory: LessonDataSourceFactory

    override fun findById(id: Int): Maybe<TimeTable> {
        val baseDataSource = timeTableFactory.createBaseDataSource()
        return baseDataSource.getById(id)
            .map {
                TimeTableDataMapper.convert(it, mutableListOf())
            }.mergeWith {
                timeTableFactory.createCloudDataSource().getById(id)
                    .map { tableDTO ->
                        val timeTableEntity = TimeTableDataMapper.convert(tableDTO)
                        baseDataSource.save(timeTableEntity)
                        TimeTableDataMapper.convert(timeTableEntity, mutableListOf())
                    }
            }
        return timeTableFactory.createCloudDataSource()
            .getById(id).map {
                convertAndSaveDataOf(it)
                TimeTableDataMapper.convert(it)
            }
            .doOnSuccess {
                timeTableFactory.createBaseDataSource().save(it)
            }.map {
            TimeTableDataMapper.convert(it,)
        }
    }

    private fun convertAndSaveDataOf(tableDTO: TimeTableDTO) {
        val convertedListDays = tableDTO.listDays.map { dayDTO ->
            convertAndSaveDataOf(dayDTO)
            DayDataMapper.convert(dayDTO)
        }

        dayFactory.createBaseDataSource().save(convertedListDays)
    }

    private fun convertAndSaveDataOf(dayDTO: DayDTO) {
        val convertedListLesson = dayDTO.listLessons.map { lessonDTO ->
            convertAndSaveDataOf(lessonDTO)
            LessonDataMapper.convert(lessonDTO)
        }

        lessonFactory.createBaseDataSource().saveAll(convertedListLesson)
    }

    private fun convertAndSaveDataOf(lessonDTO: LessonDTO) {
        DisciplineDataMapper.convert(lessonDTO.disciplineDTO)

        ProfessorDataMapper.convert(lessonDTO.professorDTO)
    }
}