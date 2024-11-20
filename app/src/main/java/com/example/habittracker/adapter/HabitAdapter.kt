package com.example.habittracker.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView

class HabitAdapter(private val habits: List<String>) : RecyclerView.Adapter<HabitAdapter.HabitViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return HabitViewHolder(view)
    }

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
        holder.bind(habits[position])
    }

    override fun getItemCount(): Int {
        return habits.size
    }

    class HabitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val habitTextView: TextView = itemView.findViewById(android.R.id.text1)

        fun bind(habit: String) {
            habitTextView.text = habit
        }
    }
}
