package com.example.weathercompose.feature.weather_screen.data.model.ModelApi

import com.example.weatherfetcher.feature.data.model.ModelApi.Sys
import com.google.gson.annotations.SerializedName

data class WeatherDayRemoteModel(
    val clouds: Clouds,
    val dt: Int,
    @SerializedName("dt_txt")
    val dt_txt: String,
    @SerializedName("main")
    val main: Main,
    val pop: Double,
    val rain: Rain,
    val sys: Sys,
    val visibility: Int,
    @SerializedName("weather")
    val weather: List<Weather>,
    val wind: Wind
)