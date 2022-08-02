package com.example.weatherfetcher.feature.weather_screen.data.ui.model

import com.google.gson.annotations.SerializedName


data class WeatherRemoteModel(
    @SerializedName("main")
    val main: WeatherMainRemoteModel,

    @SerializedName("wind")
    val wind: WeatherWindRemoteModel
)
