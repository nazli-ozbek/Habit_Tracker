package com.example.habittracker.ui.mainlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.habittracker.R
import com.example.habittracker.adapter.HabitAdapter

class MainListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainlist)

        val recyclerView = findViewById<RecyclerView>(R.id.habitsRecyclerView)

        val habits = listOf(
            "Drink Water",
            "Exercise",
            "Read Books",
            "Meditation",
            "Learn Kotlin"
        )

        val adapter = HabitAdapter(habits)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}
