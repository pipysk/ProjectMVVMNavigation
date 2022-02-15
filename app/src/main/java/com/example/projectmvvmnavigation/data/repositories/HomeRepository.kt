package com.example.projectmvvmnavigation.data.repositories

import com.example.projectmvvmnavigation.data.entities.User
import com.example.projectmvvmnavigation.data.entities.Users
import com.example.projectmvvmnavigation.data.network.APIService
import com.example.projectmvvmnavigation.data.network.SafeAPIService
import com.example.projectmvvmnavigation.data.response.BaseResponse

class HomeRepository(
    val api: APIService
) : SafeAPIService() {
     fun getUsers() = api.getAllUsers()


}