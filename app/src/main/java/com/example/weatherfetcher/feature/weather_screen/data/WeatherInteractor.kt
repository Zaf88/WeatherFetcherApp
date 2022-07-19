package com.example.weatherfetcher.feature.weather_screen.data

class WeatherInteractor(private val weatherRepo: WeatherRepo) {

    fun getWeather(): String {
    return weatherRepo.getTemperature()
    }
}