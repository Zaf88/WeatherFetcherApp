package com.example.weatherfetcher



    class WeatherRepoImpl(private val weatherRemoteSource: WeatherRemoteSource) : WeatherRepo {

        override fun getWindDirection(): String {
            return weatherRemoteSource.getWeather().message()}}
