package com.example.projectmvvmnavigation.ui.auth

import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projectmvvmnavigation.data.entities.User
import com.example.projectmvvmnavigation.data.repositories.UserRepository
import com.example.projectmvvmnavigation.utils.Coroutines


class AuthViewModel:ViewModel() {
    var email: String? = "eve.holt@reqres.in"
    var password: String? = "cityslicka"
    var authListener: AuthListener? = null
    var isShowProgressBar = ObservableBoolean(false)
    var userLiveData = MutableLiveData<User?>()

    fun onClickButtonLogin(view: View) {
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invalid email and password")
            return
        }
        authListener?.onStarted()
        val loginResponse = UserRepository().userLogin(email!!, password!!)
        authListener?.onSuccess(loginResponse)
    }


    fun getUserInfo() {
        Coroutines.main {
            val response = UserRepository().getUserInfo()
            if (response.data != null) {
                userLiveData.postValue(response.data)
            } else {
                userLiveData.postValue(null)
            }
        }
    }
}