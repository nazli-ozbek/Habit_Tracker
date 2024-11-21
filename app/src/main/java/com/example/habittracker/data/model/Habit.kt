package com.example.habittracker.data.model

import java.time.LocalDate
import java.util.Date

data class Habit(
    val name: String,
    val description:String,
    var startDate: Date,
    val completedDates: MutableList<LocalDate> = mutableListOf()
)
