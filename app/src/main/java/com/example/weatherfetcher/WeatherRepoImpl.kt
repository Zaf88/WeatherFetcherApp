package com.example.weatherfetcher

import com.example.weatherfetcher.feature.weather_screen.data.ui.temperatureToDomain
import com.example.weatherfetcher.feature.weather_screen.data.ui.windToDomain
import com.example.weatherfetcher.model.WeatherModel
import com.example.weatherfetcher.model.WindModel


class WeatherRepoImpl(private val weatherRemoteSource: WeatherRemoteSource) : WeatherRepo {
    override suspend fun getTemperature(): WeatherModel {
        return weatherRemoteSource.getWeather().temperatureToDomain()
    }

    override suspend fun getWind(): WindModel {
        return weatherRemoteSource.getWeather().windToDomain()
    }

}