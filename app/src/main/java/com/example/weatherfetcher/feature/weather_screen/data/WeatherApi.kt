package com.example.weatherfetcher.feature.weather_screen.data

import com.example.weatherfetcher.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET
    fun getWeather(
        @Query("q") query:String,
        @Query("units") units: String = "metric",
        @Query("appid") apiKey: String = API_KEY,
    ): Response<String>
}