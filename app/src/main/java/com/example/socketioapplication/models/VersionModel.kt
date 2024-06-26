package com.example.socketioapplication.models

import com.google.gson.annotations.SerializedName

data class VersionModel(
    @SerializedName("Condition")
    val Condition: String,
    @SerializedName("Holyday")
    val Holyday: String,
    @SerializedName("ONTime")
    val ONTime: String,
    @SerializedName("Player")
    val Player: List<String>,
    @SerializedName("Ver")
    val Ver: String = "0",
    @SerializedName("category")
    val categoryList: List<String>,
    @SerializedName("VideoList")
    val VideoList: List<String>,
    @SerializedName("needToUpp")
    val needToUpp: Boolean,
    @SerializedName("onOffTimeSchedule")
    val onOffTimeSchedule: List<OnOffTimeSchedule>,
    @SerializedName("updateDate")
    val updateDate: UpdateDate,
    @SerializedName("versionApp")
    val versionApp: Double
)
