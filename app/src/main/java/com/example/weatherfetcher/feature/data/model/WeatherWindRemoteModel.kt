package com.example.weatherfetcher.feature.data.model

import com.google.gson.annotations.SerializedName


data class WeatherWindRemoteModel(
    @SerializedName("deg")
    val windDeg: String

)