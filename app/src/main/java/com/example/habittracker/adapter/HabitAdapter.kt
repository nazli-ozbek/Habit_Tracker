package com.example.habittracker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.habittracker.data.model.Habit
import com.example.habittracker.databinding.HabitItemBinding

class HabitAdapter(
    private val onDeleteClick: (Habit) -> Unit
) : ListAdapter<Habit, HabitAdapter.HabitViewHolder>(HabitDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val binding = HabitItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HabitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
        val habit = getItem(position)
        holder.bind(habit)


        holder.binding.deleteButton.setOnClickListener {
            onDeleteClick(habit)
        }
    }

    inner class HabitViewHolder(val binding: HabitItemBinding) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {

        fun bind(habit: Habit) {
            binding.habit = habit
            binding.executePendingBindings()
        }
    }


    class HabitDiffCallback : DiffUtil.ItemCallback<Habit>() {
        override fun areItemsTheSame(oldItem: Habit, newItem: Habit): Boolean {

            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Habit, newItem: Habit): Boolean {

            return oldItem == newItem
        }
    }
}
