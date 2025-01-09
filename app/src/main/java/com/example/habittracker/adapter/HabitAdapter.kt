package com.example.habittracker.adapter

import android.animation.ObjectAnimator
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.habittracker.R
import com.example.habittracker.data.model.Habit
import com.example.habittracker.databinding.HabitItemBinding

class HabitAdapter(
    private val onDeleteClick: (Habit) -> Unit
) : RecyclerView.Adapter<HabitAdapter.HabitViewHolder>() {

    private var habitList = listOf<Habit>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val binding = HabitItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HabitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
        val habit = habitList[position]
        holder.bind(habit)

        val backgroundView = holder.binding.root
        backgroundView.alpha = 0f
        val fadeInBackground = ObjectAnimator.ofFloat(backgroundView, "alpha", 0f, 1f)
        fadeInBackground.duration = 600
        fadeInBackground.startDelay = 300L * position
        fadeInBackground.start()

        val fadeIn = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.fade_in)
        holder.binding.habitNameTextView.startAnimation(fadeIn.apply { startOffset = 500L * position })
        holder.binding.habitDescriptionTextView.startAnimation(fadeIn)
        holder.binding.streakTextView.startAnimation(fadeIn)

        holder.binding.deleteButton.setOnClickListener {
            onDeleteClick(habit)
        }
    }

    override fun getItemCount(): Int = habitList.size

    fun submitList(habits: List<Habit>) {
        habitList = habits
        notifyDataSetChanged()
    }

    inner class HabitViewHolder(val binding: HabitItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(habit: Habit) {
            binding.habit = habit
            binding.executePendingBindings()
        }
    }
}
