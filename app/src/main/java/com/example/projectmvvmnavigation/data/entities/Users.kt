package com.example.projectmvvmnavigation.data.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("data")
    @Expose
    val `data`: List<Data>,
    @SerializedName("page")
    @Expose
    val page: Int,
    @SerializedName("per_page")
    @Expose
    val per_page: Int,
    @SerializedName("support")
    @Expose
    val support: Support,
    @SerializedName("total")
    @Expose
    val total: Int,
    @SerializedName("total_pages")
    @Expose
    val total_pages: Int
)