package com.example.weatherfetcher
import retrofit2.Response
class WeatherRemoteSource {

    // TODO add query
    fun getWeather(): Response<String> {
        return api.getWeather(query = "Moscow")
    }
}
