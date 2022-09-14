package com.example.weatherfetcher.feature.data

import com.example.weatherfetcher.feature.data.model.WeatherRemoteModel
import com.example.weatherfetcher.feature.ui.model.WeatherModel
import com.example.weatherfetcher.feature.ui.model.WindModel


fun WeatherRemoteModel.temperatureToDomain() = WeatherModel(
    temperature = this.main.temperature
)

fun WeatherRemoteModel.windToDomain() = WindModel(
    windDeg = this.wind.windDeg
)
