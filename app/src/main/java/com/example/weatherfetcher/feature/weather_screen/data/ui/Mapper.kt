package com.example.weatherfetcher.feature.weather_screen.data.ui

import com.example.weatherfetcher.feature.weather_screen.data.ui.model.WeatherRemoteModel
import com.example.weatherfetcher.model.WeatherModel
import com.example.weatherfetcher.model.WindModel


fun WeatherRemoteModel.temperatureToDomain() = WeatherModel(
    temperature = this.main.temperature
)

fun WeatherRemoteModel.windToDomain() = WindModel(
    windDeg = this.wind.windDeg
)
