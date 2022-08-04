package com.example.weatherfetcher.feature.weather_screen.data.ui

import com.example.weatherfetcher.Base.Event


data class ViewState(
    val isLoading: Boolean,
    val title: String,
    val temperature: String,
    val windDeg: String
)

sealed class UiEvent() : Event {
    object OnButtonClicked : UiEvent()
    object WindIsLoaded : UiEvent()
   }

sealed class DataEvent : Event {
    data class OnWeatherFetchSucceed(val temperature: String) : DataEvent()
    data class OnWindFetchSucceed(val windDeg: String) : DataEvent()
    data class OnWeatherFetchFailed(val error: Throwable) : DataEvent()
}