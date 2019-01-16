package com.nstu.domain.model.discipline

data class Lesson(
    val id: Int,
    val type: String,
    val topic: String,
    val time: Time
) {
    data class Time(
        val start: java.sql.Time,
        val end: java.sql.Time
    )
}
