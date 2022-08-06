package com.example.weatherfetcher.feature.weather_screen.data

import com.example.weatherfetcher.feature.weather_screen.data.ui.model.WeatherModel

interface WeatherRepo {
    suspend fun getTemperature(): WeatherModel
}