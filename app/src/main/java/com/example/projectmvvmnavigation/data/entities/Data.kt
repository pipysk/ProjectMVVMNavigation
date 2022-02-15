package com.example.projectmvvmnavigation.data.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("avatar")
    @Expose
    val avatar: String,
    @SerializedName("email")
    @Expose
    val email: String,
    @SerializedName("first_name")
    @Expose
    val first_name: String,
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("last_name")
    @Expose
    val last_name: String
)