package com.example.weatherfetcher.feature.data

import com.example.weatherfetcher.feature.ui.model.WeatherModel
import com.example.weatherfetcher.feature.ui.model.WindModel

interface WeatherRepo {

    suspend fun getTemperature(): WeatherModel
    suspend fun getWind(): WindModel
}