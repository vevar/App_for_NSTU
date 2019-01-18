package com.nstu.data.util.parser

import com.nstu.data.repository.factory.datasource.cloud.dto.TimeTableDTO
import java.io.InputStream

interface ParserTimeTable {
    fun parse(inputStream: InputStream): TimeTableDTO
}