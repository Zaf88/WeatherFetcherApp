package com.example.weatherfetcher

import com.example.weatherfetcher.Base.Either
import com.example.weatherfetcher.Base.attempt
import com.example.weatherfetcher.model.WeatherModel
import com.example.weatherfetcher.model.WindModel




    class WeatherInteractor(private val weatherRepo: WeatherRepo) {

        suspend fun getWeather(): Either<Throwable, WeatherModel> {
            return attempt { weatherRepo.getTemperature() }
        }

        suspend fun getWind(): Either<Throwable, WindModel> {
            return attempt { weatherRepo.getWind() }
        }
    }

