package com.example.habittracker.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.habittracker.data.model.Habit
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import java.time.LocalDate

class HabitViewModel : ViewModel() {
    private val database = FirebaseDatabase.getInstance().reference
    private val userId = FirebaseAuth.getInstance().currentUser?.uid

    val habitList = MutableLiveData<List<Habit>>()

    fun addHabit(habit: Habit) {
        userId?.let { uid ->
            database.child("users").child(uid).child("habits").push().setValue(habit)
        }
    }

    fun fetchHabits() {
        userId?.let { uid ->
            database.child("users").child(uid).child("habits").get()
                .addOnSuccessListener { snapshot ->
                    val habits = snapshot.children.mapNotNull { it.getValue(Habit::class.java) }
                    habitList.value = habits
                }
        }
    }
}
