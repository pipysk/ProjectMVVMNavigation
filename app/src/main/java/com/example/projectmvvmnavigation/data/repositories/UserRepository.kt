package com.example.projectmvvmnavigation.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.projectmvvmnavigation.data.entities.User
import com.example.projectmvvmnavigation.data.network.APIService
import com.example.projectmvvmnavigation.data.request.LoginRequest
import com.example.projectmvvmnavigation.data.response.BaseResponse
import com.example.projectmvvmnavigation.data.response.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    fun userLogin(email: String, password: String): LiveData<LoginResponse?> {
        val loginResponse = MutableLiveData<LoginResponse?>()
        val loginRequest = LoginRequest(email, password)
        APIService().userLogin(loginRequest).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful && response.code() == 200) {
                    loginResponse.value = response.body()
                } else {
                    loginResponse.value = null
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                loginResponse.postValue(null)
            }

        })
        return loginResponse
    }
    suspend fun getUserInfo():BaseResponse<User>{
        return APIService().getUserInfo()
    }
}