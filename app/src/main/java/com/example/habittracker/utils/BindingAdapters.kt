package com.example.habittracker.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("formattedDate")
fun bindFormattedDate(textView: TextView, date: Date?) {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val formattedDate = date?.let { dateFormat.format(it) } ?: "No Date"
    textView.text = formattedDate
}
