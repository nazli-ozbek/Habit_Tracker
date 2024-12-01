package com.example.habittracker.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("formattedDate")
fun bindFormattedDate(textView: TextView, dateString: String?) {
    val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
    val formattedDate = dateString?.let {
        try {
            val date = dateFormat.parse(it)
            date?.let { dateFormat.format(date) } ?: "Invalid Date"
        } catch (e: Exception) {
            "Invalid Date"
        }
    } ?: "No Date"
    textView.text = formattedDate
}
