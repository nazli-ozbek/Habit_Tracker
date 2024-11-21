package com.example.habittracker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.habittracker.data.model.Habit
import com.example.habittracker.databinding.HabitItemBinding // Updated binding class
import java.text.SimpleDateFormat
import java.util.*

class HabitAdapter : RecyclerView.Adapter<HabitAdapter.HabitViewHolder>() {

    private var habitList = listOf<Habit>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val binding = HabitItemBinding.inflate(LayoutInflater.from(parent.context), parent, false) // Updated binding
        return HabitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
        val habit = habitList[position]
        holder.bind(habit)
    }

    override fun getItemCount(): Int = habitList.size

    fun submitList(habits: List<Habit>) {
        habitList = habits
        notifyDataSetChanged()
    }

    inner class HabitViewHolder(private val binding: HabitItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(habit: Habit) {
            binding.habit = habit

            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val formattedDate = habit.startDate?.let { dateFormat.format(it) } ?: "No Date"

            binding.habitDateTextView.text = formattedDate

            binding.executePendingBindings()
        }
    }
}
