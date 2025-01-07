package com.example.habittracker.repository

import com.example.habittracker.data.model.Habit
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class HabitRepository {
    private val firestore = FirebaseFirestore.getInstance()
    private val firebaseAuth = FirebaseAuth.getInstance()

    suspend fun getHabits(): List<Habit> {
        val userId = firebaseAuth.currentUser?.uid ?: return emptyList()

        return try {
            val snapshot = firestore.collection("habits")
                .whereEqualTo("userId", userId)
                .get()
                .await()

            snapshot.documents.mapNotNull { document ->
                document.toObject(Habit::class.java)
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun deleteHabit(habit: Habit) {
        try {
            val userId = firebaseAuth.currentUser?.uid ?: return
            val snapshot = firestore.collection("habits")
                .whereEqualTo("name", habit.name)
                .whereEqualTo("userId", userId)
                .get()
                .await()

            for (document in snapshot.documents) {
                document.reference.delete().await()
            }
        } catch (e: Exception) {

        }
    }
}
