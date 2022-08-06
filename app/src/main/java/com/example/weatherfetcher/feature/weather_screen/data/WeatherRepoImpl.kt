package com.example.weatherfetcher.feature.weather_screen.data

import com.example.weatherfetcher.feature.weather_screen.data.model.toDomain
import com.example.weatherfetcher.feature.weather_screen.data.ui.model.WeatherModel

class WeatherRepoImpl(private val weatherRemoteSource: WeatherRemoteSource): WeatherRepo{

    override suspend fun getTemperature(): WeatherModel {
        return weatherRemoteSource.getWeather().toDomain()
    }
}