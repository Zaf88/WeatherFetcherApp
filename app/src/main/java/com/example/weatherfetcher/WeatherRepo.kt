package com.example.weatherfetcher

import com.example.weatherfetcher.model.WeatherModel
import com.example.weatherfetcher.model.WindModel

interface WeatherRepo {

    suspend fun getTemperature(): WeatherModel
    suspend fun getWind(): WindModel
}