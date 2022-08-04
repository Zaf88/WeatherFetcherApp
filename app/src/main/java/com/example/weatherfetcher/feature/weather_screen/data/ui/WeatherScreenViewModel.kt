package com.example.weatherfetcher.feature.weather_screen.data.ui

import androidx.lifecycle.ViewModel


class WeatherScreenViewModel(val interactor: WeatherInteractor):ViewModel() {

    suspend fun getWeather(): String {
        return interactor.getWeather()
    }
}