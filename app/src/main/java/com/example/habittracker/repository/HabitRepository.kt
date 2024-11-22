package com.example.habittracker.repository

import com.example.habittracker.data.model.Habit
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class HabitRepository {
    private val firestore = FirebaseFirestore.getInstance()
    private val firebaseAuth = FirebaseAuth.getInstance()

    suspend fun getHabits(): List<Habit> {
        val userId = firebaseAuth.currentUser?.uid
        if (userId == null) {
            return emptyList()
        }

        return try {
            val snapshot = firestore.collection("habits")
                .whereEqualTo("userId", userId)
                .get()
                .await()

            snapshot.documents.map { document ->
                document.toObject(Habit::class.java) ?: Habit()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}
