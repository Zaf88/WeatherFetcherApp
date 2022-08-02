package com.example.weatherfetcher.feature.weather_screen.data.ui.model

import com.google.gson.annotations.SerializedName


data class WeatherWindRemoteModel(
    @SerializedName("deg")
    val windDeg: String

)