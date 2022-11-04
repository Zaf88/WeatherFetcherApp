package com.example.weatherfetcher.feature.data

import com.example.weatherfetcher.feature.weather_screen.API_KEY
import com.example.weatherfetcher.feature.data.model.WeatherRemoteModel
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApi {
        @GET("weather")
     suspend fun getWeather(
            @Query("q") query:String,
            @Query("units") units: String = "metric",
            @Query("appid") apiKey: String = API_KEY,
            @Query("lang") lang: String = "ru",
        ): WeatherRemoteModel
    }
