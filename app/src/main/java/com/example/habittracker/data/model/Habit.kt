package com.example.habittracker.data.model

import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

data class Habit(
    val name: String = "",
    val description: String = "",
    val date: String = "",
    val userId: String = ""

) : Serializable {

    val streak: String
        get() {
            return calculateStreak(date)
        }

    private fun calculateStreak(startDateString: String?): String {
        return startDateString?.let {
            val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            val startDate = dateFormat.parse(it)

            startDate?.let { date ->
                val diffInMillis = Date().time - date.time
                val streak = (diffInMillis / (1000 * 60 * 60 * 24)).toInt()
                streak.toString()
            } ?: "0"
        } ?: "0"
    }
}