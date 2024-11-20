package com.example.habittracker.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.habittracker.data.model.Habit
import com.example.habittracker.databinding.HabitItemBinding

class HabitViewHolder(private val binding: HabitItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(habit: Habit, clickListener: (Habit) -> Unit) {
        binding.habit = habit
        binding.root.setOnClickListener { clickListener(habit) }
        binding.executePendingBindings()
    }
}
