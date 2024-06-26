package com.example.socketioapplication.models

import com.google.gson.annotations.SerializedName

data class Time(
    @SerializedName("hour")
    val hour: String,
    @SerializedName("minute")
    val minute: String
)
