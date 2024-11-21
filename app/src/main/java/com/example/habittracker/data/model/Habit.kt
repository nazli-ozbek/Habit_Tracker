package com.example.habittracker.data.model

import java.time.LocalDate
import java.util.Date

data class Habit(
    val name: String,
    val startDate: Date,
    var streak: Int = 0,
    val completedDates: MutableList<LocalDate> = mutableListOf()
)
