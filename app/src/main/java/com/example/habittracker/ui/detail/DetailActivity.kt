package com.example.habittracker.ui.detail

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.habittracker.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val habitNameTextView = findViewById<TextView>(R.id.habitNameTextView)
        val habitDescriptionTextView = findViewById<TextView>(R.id.habitDescriptionTextView)
        val habitStreakTextView = findViewById<TextView>(R.id.habitStreakTextView)
        val markAsCompleteButton = findViewById<Button>(R.id.markAsCompleteButton)

        val habitName = "Drink Water"
        val habitDescription = "Drink at least 8 glasses of water every day."
        val habitStreak = 5

        habitNameTextView.text = habitName
        habitDescriptionTextView.text = habitDescription
        habitStreakTextView.text = "Current Streak: $habitStreak days"

        markAsCompleteButton.setOnClickListener {

        }
    }
}
