package com.example.habittracker.repository

import com.example.habittracker.data.model.Habit
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class HabitRepository {
    private val firestore = FirebaseFirestore.getInstance()

    suspend fun getHabits(): List<Habit> {
        return try {
            val snapshot = firestore.collection("habits").get().await()
            snapshot.documents.map { document ->
                document.toObject(Habit::class.java) ?: Habit()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}
