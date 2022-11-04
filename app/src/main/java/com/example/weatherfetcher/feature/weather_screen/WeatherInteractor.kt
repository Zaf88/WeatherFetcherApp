package com.example.weatherfetcher.feature.weather_screen

import com.example.weatherfetcher.Base.Either
import com.example.weatherfetcher.Base.attempt
import com.example.weatherfetcher.feature.data.WeatherMainModel
import com.example.weatherfetcher.feature.data.WeatherRepo
import com.example.weatherfetcher.feature.ui.model.WeatherModel
import com.example.weatherfetcher.feature.ui.model.WindModel




    class WeatherInteractor(private val weatherRepo: WeatherRepo) {

        suspend fun getWeather(): Either<Throwable, WeatherModel> {
            return attempt { weatherRepo.getTemperature() }
        }

        suspend fun getWind(): Either<Throwable, WindModel> {
            return attempt { weatherRepo.getWind() }
        }
        suspend fun getWeather(city: String): Either<Throwable, List<WeatherMainModel>> {
            return attempt { weatherRepo.getAllWeather(city = city) }
        }

    }



