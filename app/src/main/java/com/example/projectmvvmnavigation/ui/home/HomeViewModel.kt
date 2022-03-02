package com.example.projectmvvmnavigation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projectmvvmnavigation.data.entities.Data
import com.example.projectmvvmnavigation.data.entities.Users
import com.example.projectmvvmnavigation.data.repositories.HomeRepository
import com.example.projectmvvmnavigation.utils.Coroutines
import kotlinx.coroutines.Job


class HomeViewModel(
    private val repository: HomeRepository
) : ViewModel() {

    private lateinit var job: Job
    private val _homes = MutableLiveData<List<Data>>()
    val homes: LiveData<List<Data>>
        get() = _homes

    fun getHomes() {
        job = Coroutines.ioThenMain(
            { repository.getUsers() },
            { _homes.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}




