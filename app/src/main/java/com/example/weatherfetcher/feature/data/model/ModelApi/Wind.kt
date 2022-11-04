package com.example.weathercompose.feature.weather_screen.data.model.ModelApi

import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("deg")
    val deg: Int,
    @SerializedName("gust")
    val gust: Double,
    val speed: Double
)