package com.example.habittracker.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.habittracker.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class HabitDetailFragment : Fragment() {

    private lateinit var habitNameEditText: EditText
    private lateinit var habitDescriptionEditText: EditText
    private lateinit var habitDateEditText: EditText
    private lateinit var saveButton: Button
    private val firestore: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }
    private val firebaseAuth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_habit_detail, container, false)

        habitNameEditText = view.findViewById(R.id.habitNameEditText)
        habitDescriptionEditText = view.findViewById(R.id.habitDescriptionEditText)
        habitDateEditText = view.findViewById(R.id.habitDateEditText)
        saveButton = view.findViewById(R.id.saveButton)
        val returnHomeButton: Button = view.findViewById(R.id.returnHomeButton)
        val backgroundShape: View = view.findViewById(R.id.backgroundShape)

        val fadeIn = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in)
        val slideDown = AnimationUtils.loadAnimation(requireContext(), R.anim.bottom_down)

        backgroundShape.startAnimation(slideDown)
        habitNameEditText.startAnimation(fadeIn)
        habitDescriptionEditText.startAnimation(fadeIn)
        habitDateEditText.startAnimation(fadeIn)
        saveButton.startAnimation(fadeIn)
        returnHomeButton.startAnimation(fadeIn)

        saveButton.setOnClickListener { saveHabit() }

        returnHomeButton.setOnClickListener {
            findNavController().navigate(R.id.action_habitDetailFragment_to_mainFragment)
        }

        return view
    }

    private fun saveHabit() {
        val habitName = habitNameEditText.text.toString().trim()
        val habitDescription = habitDescriptionEditText.text.toString().trim()
        val habitDate = habitDateEditText.text.toString().trim()

        if (habitName.isEmpty() || habitDate.isEmpty()) {
            Toast.makeText(context, "Please fill all required fields", Toast.LENGTH_SHORT).show()
            return
        }

        if (!habitDate.matches(Regex("\\d{2}-\\d{2}-\\d{4}"))) {
            Toast.makeText(context, "Invalid date format! Use DD-MM-YYYY.", Toast.LENGTH_SHORT).show()
            return
        }

        val habitData = mapOf(
            "name" to habitName,
            "description" to habitDescription,
            "date" to habitDate,
            "userId" to firebaseAuth.currentUser?.uid
        )

        firestore.collection("habits")
            .add(habitData)
            .addOnSuccessListener {
                Toast.makeText(context, "Habit saved!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_habitDetailFragment_to_mainFragment)
            }
            .addOnFailureListener {
                Toast.makeText(context, "Error saving habit", Toast.LENGTH_SHORT).show()
            }
    }
}
