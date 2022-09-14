package com.example.weatherfetcher.feature.data

import com.example.weatherfetcher.feature.ui.model.WeatherModel
import com.example.weatherfetcher.feature.ui.model.WindModel


class WeatherRepoImpl(private val weatherRemoteSource: WeatherRemoteSource) : WeatherRepo {
    override suspend fun getTemperature(): WeatherModel {
        return weatherRemoteSource.getWeather().temperatureToDomain()
    }

    override suspend fun getWind(): WindModel {
        return weatherRemoteSource.getWeather().windToDomain()
    }

}