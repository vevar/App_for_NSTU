package com.gwsf.data.util.parser

import com.gwsf.data.repository.factory.datasource.cloud.dto.TimeTableDTO
import java.io.InputStream

interface ParserTimeTable {
    fun parse(inputStream: InputStream): TimeTableDTO
}