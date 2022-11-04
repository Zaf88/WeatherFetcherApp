package com.example.weatherfetcher.feature.data

import com.example.weatherfetcher.feature.ui.model.WeatherModel
import com.example.weatherfetcher.feature.ui.model.WindModel


abstract class WeatherRepoImpl(private val weatherRemoteSource: WeatherRemoteSource) : WeatherRepo {
    override suspend fun getTemperature(): WeatherModel {
        TODO("Not yet implemented")
    }

    override suspend fun getWind(): WindModel {
        TODO("Not yet implemented")
    }

    override suspend fun getAllWeather(city: String): List <WeatherMainModel> {
        return weatherRemoteSource.getWeather(city = city)
            .list
            .asSequence()
            .map{it.toDomain()}
            .toList()
    }


}

private fun Any.toDomain() {
    TODO("Not yet implemented")
}
