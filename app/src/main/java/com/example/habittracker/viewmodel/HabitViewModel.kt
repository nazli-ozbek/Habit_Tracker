package com.example.habittracker.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.habittracker.data.model.Habit
import java.time.LocalDate

class HabitViewModel : ViewModel() {
    val habitName = MutableLiveData<String>()
    val habitStartDate= MutableLiveData<String>()
    val habitList = MutableLiveData<List<Habit>>(mutableListOf())

}
