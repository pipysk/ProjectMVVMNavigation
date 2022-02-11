package com.example.projectmvvmnavigation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projectmvvmnavigation.data.entities.Data
import com.example.projectmvvmnavigation.data.entities.User
import com.example.projectmvvmnavigation.data.entities.Users
import com.example.projectmvvmnavigation.data.repositories.HomeRepository

class HomeViewModel(
    private val repository: HomeRepository
) : ViewModel() {

    private val _homes = MutableLiveData<Users?>()
    val homes: LiveData<Users?>
        get() = _homes

    suspend fun getUsers(){
        val homes=repository.getUsers()
        _homes.value = homes
    }
}


