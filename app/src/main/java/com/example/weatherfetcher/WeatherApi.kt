package com.example.weatherfetcher

import com.example.weatherfetcher.feature.weather_screen.data.ui.model.WeatherRemoteModel
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApi {
        @GET("weather")
     suspend fun getWeather(
            @Query("q") query:String,
            @Query("units") units: String = "metric",
            @Query("appid") apiKey: String = API_KEY): WeatherRemoteModel
    }
