package com.gwsf.appfornstu.data.util.parser

import com.gwsf.appfornstu.data.repository.factory.datasource.cloud.dto.TimeTableDTO
import java.io.InputStream

interface ParserTimeTable {
    fun parse(inputStream: InputStream): TimeTableDTO
}