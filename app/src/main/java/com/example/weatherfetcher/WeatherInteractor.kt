package com.example.weatherfetcher

class WeatherInteractor {

    class WeatherInteractor(private val weatherRepo: WeatherRepo) {

        fun getWeather(): String {
            return weatherRepo.getWindDirection()
        }
    }
}