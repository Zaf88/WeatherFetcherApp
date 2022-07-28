package com.example.weatherfetcher.feature.weather_screen.data

import com.example.weatherfetcher.base.Either
import com.example.weatherfetcher.base.attempt
import com.example.weatherfetcher.feature.weather_screen.data.ui.model.WeatherModel

class WeatherInteractor(private val weatherRepo: WeatherRepo) {

    suspend fun getWeather(): Either<Throwable,WeatherModel> {
    return attempt { weatherRepo.getTemperature()  }
    }
}