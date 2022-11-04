package com.example.weathercompose.feature.weather_screen.data.model.ModelApi

import com.google.gson.annotations.SerializedName

data class WeatherRemoteModel(
    val city: City,
    val cnt: Int,
    val cod: String,
    @SerializedName("list")
    val list: List<WeatherDayRemoteModel>,
    val message: Int
)