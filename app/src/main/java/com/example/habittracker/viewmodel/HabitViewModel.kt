package com.example.habittracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.habittracker.data.model.Habit
import com.example.habittracker.repository.HabitRepository
import kotlinx.coroutines.launch

class HabitViewModel(application: Application) : AndroidViewModel(application) {
    private val habitRepository = HabitRepository()

    private val _habitList = MutableLiveData<List<Habit>>()
    val habitList: LiveData<List<Habit>> = _habitList

    fun fetchHabits() {
        viewModelScope.launch {
            val habits = habitRepository.getHabits()
            _habitList.value = habits
        }
    }
}

