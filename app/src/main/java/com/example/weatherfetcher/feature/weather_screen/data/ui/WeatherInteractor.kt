package com.example.weatherfetcher.feature.weather_screen.data.ui

import com.example.weatherfetcher.feature.weather_screen.data.WeatherRepo


class WeatherInteractor(private val weatherRepo: WeatherRepo) {

    suspend fun getWeather():String {
        return weatherRepo.getTemperature()
    }

}