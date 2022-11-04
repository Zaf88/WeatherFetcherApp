package com.example.weatherfetcher.feature.data


import com.example.weathercompose.feature.weather_screen.data.model.ModelApi.WeatherDayRemoteModel
import com.example.weatherfetcher.feature.data.model.WeatherRemoteModel
import com.example.weatherfetcher.feature.ui.model.WeatherModel
import com.example.weatherfetcher.feature.ui.model.WindModel


fun WeatherRemoteModel.temperatureToDomain() = WeatherModel(
    temperature = this.main.temperature
)

fun WeatherRemoteModel.windToDomain() = WindModel(
    windDeg = this.wind.windDeg
)
fun WeatherDayRemoteModel.toDomain() = WeatherMainModel(
    temperature = main.temp,
    description = weather
        .map { it.description }
        .toString()
        .removeSurrounding("[", "]")
        .capitalize(),
    icon = weather
        .map { it.icon }
        .toString()
        .removeSurrounding("[", "]"),
    windDeg = dt_txt,
    windSpeed = dt_txt,
    allDateWeather = dt_txt,

    )
