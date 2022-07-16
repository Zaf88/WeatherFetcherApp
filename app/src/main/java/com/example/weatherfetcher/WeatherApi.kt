package com.example.weatherfetcher

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET
    fun getWeather(
    @Query("q") query:String,
    @Query("appid") apiKey: String = API_KEY,
    )
}