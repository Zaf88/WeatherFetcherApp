package com.example.weatherfetcher
import com.example.weatherfetcher.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
interface WeatherApi {


    interface WeatherApi {
        @GET
        fun getWeather(
            @Query("q") query:String,
            @Query("appid") apiKey: String = API_KEY,
        ): Response<String>
    }
}

