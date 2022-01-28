package com.example.projectmvvmnavigation.ui.auth

import androidx.lifecycle.LiveData
import com.example.projectmvvmnavigation.data.response.LoginResponse

interface AuthListener {
    fun onStarted()
    fun onSuccess(message: LiveData<LoginResponse?>)
    fun onFailure(message: String)

}