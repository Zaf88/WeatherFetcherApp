package com.example.weatherfetcher


import okhttp3.OkHttpClient
import retrofit2.Retrofit

object WeatherApiClient {

    private val okHttpClient =OkHttpClient.Builder()
        .build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()
    private val weatherApi = retrofit.create(WeatherApi::class.java)
    fun getApi(): WeatherApi {
        return weatherApi

    }
}