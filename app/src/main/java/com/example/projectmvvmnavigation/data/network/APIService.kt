package com.example.projectmvvmnavigation.data.network

import com.example.projectmvvmnavigation.data.entities.User
import com.example.projectmvvmnavigation.data.entities.Users
import com.example.projectmvvmnavigation.data.request.LoginRequest
import com.example.projectmvvmnavigation.data.response.BaseResponse
import com.example.projectmvvmnavigation.data.response.LoginResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIService {
    @POST("login")
    fun userLogin(
        @Body requestBody: LoginRequest
    ): Call<LoginResponse>

    @GET("/api/users/2")
    suspend fun getUserInfo(): BaseResponse<User>

    @GET("users")
    fun getAllUsers(): Call<Users>



    companion object {
        private const val BASE_URL = "https://reqres.in/api/"
        operator fun invoke(): APIService {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            //HTTP Client
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(APIService::class.java)
        }
    }
}