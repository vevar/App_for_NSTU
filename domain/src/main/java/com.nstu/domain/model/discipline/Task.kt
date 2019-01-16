package com.nstu.domain.model.discipline

import java.io.File

data class Task(
    val id: Int,
    val text: Int,
    val listFiles: List<File>,
    val maxPoint: Int
)