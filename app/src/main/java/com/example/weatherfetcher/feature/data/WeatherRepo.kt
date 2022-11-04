package com.example.weatherfetcher.feature.data

import com.example.weatherfetcher.feature.ui.model.WeatherModel
import com.example.weatherfetcher.feature.ui.model.WindModel

interface WeatherRepo {

    abstract val it: Any

    suspend fun getTemperature(): WeatherModel
    suspend fun getWind(): WindModel
    suspend fun getAllWeather(city: String):List<WeatherMainModel>
}