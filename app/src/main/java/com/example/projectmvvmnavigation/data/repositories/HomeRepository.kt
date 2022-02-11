package com.example.projectmvvmnavigation.data.repositories

import com.example.projectmvvmnavigation.data.network.APIService
import com.example.projectmvvmnavigation.data.network.SafeAPIService

class HomeRepository(
    private val api: APIService
) : SafeAPIService() {
    suspend fun getUsers() = apiRequest { api.getAllUsers() }
}