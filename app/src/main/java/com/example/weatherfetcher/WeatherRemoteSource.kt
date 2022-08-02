package com.example.weatherfetcher
import com.example.weatherfetcher.feature.weather_screen.data.ui.model.WeatherRemoteModel



    class WeatherRemoteSource(private  val api: WeatherApi) {
        // TODO add query
        suspend fun getWeather(): WeatherRemoteModel {
        return api.getWeather(query = "Moscow")}}