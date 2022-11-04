package com.example.weathercompose.feature.weather_screen.data.model.ModelApi

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String,
    val id: Int,
    val main: String
)