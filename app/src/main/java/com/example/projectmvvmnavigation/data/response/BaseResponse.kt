package com.example.projectmvvmnavigation.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open  class BaseResponse <T>{
    @SerializedName("data")
    @Expose
    var data:T?=null
}