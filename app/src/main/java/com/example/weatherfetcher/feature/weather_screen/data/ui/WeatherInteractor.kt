package com.example.weatherfetcher.feature.weather_screen.data.ui

import com.example.weatherfetcher.Base.Either
import com.example.weatherfetcher.Base.attempt
import com.example.weatherfetcher.feature.weather_screen.data.WeatherRepo
import com.example.weatherfetcher.feature.weather_screen.data.ui.model.WeatherModel


class WeatherInteractor(private val weatherRepo: WeatherRepo) {

    suspend fun getWeather():Either<Throwable,WeatherModel>{
        return attempt {  weatherRepo.getTemperature()}

}}