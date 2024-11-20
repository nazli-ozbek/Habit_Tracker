package com.example.habittracker.data.model

import java.time.LocalDate

data class Habit(
    val name: String,
    val startDate: LocalDate,
    var streak: Int = 0,
    val completedDates: MutableList<LocalDate> = mutableListOf()
)
