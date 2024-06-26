package com.example.socketioapplication.models

import com.google.gson.annotations.SerializedName

data class OnOffTimeSchedule(
    @SerializedName("day")
    val day: String,
    @SerializedName("onTime1")
    val onTime1: Time?,
    @SerializedName("offTime1")
    val offTime1: Time?
)
