package com.example.habittracker.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.habittracker.data.model.User

class UserViewModel : ViewModel() {
    val user =  MutableLiveData<User>()
    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()

}
