package com.nstu.data.repository.factory.datasource.cloud

import com.nstu.data.repository.factory.datasource.cloud.dto.TimeTableDTO
import io.reactivex.Maybe

interface TimeTableCloudDataSource {
    fun getById(id: Int): Maybe<TimeTableDTO>
}
