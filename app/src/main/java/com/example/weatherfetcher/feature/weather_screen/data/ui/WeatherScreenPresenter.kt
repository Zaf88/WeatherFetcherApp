package com.example.weatherfetcher.feature.weather_screen.data.ui

import com.example.weatherfetcher.feature.weather_screen.data.WeatherInteractor

class WeatherScreenPresenter(val interactor: WeatherInteractor) {

    fun getWeather(): String {

        return interactor.getWeather()


    }
}