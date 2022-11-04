package com.example.weathercompose.feature.weather_screen.data.model.ModelApi

import com.google.gson.annotations.SerializedName

data class Main(
    val feels_like: Double,
    val grnd_level: Int,
    val humidity: Int,
    val pressure: Int,
    val sea_level: Int,
    @SerializedName("temp")
    val temp: Double,
    val temp_kf: Double,
    val temp_max: Double,
    val temp_min: Double
)