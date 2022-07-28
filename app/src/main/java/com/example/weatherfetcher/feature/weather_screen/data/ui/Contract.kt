package com.example.weatherfetcher.feature.weather_screen.data.ui

import com.example.weatherfetcher.base.Event

data class ViewState(
    val isLoading: Boolean,
    val title: String,
    val temperature: String
)

sealed class UIEvent : Event {
    object OnButtonClicked : UIEvent()
}

sealed class DataEvent : Event {
    data class OnWeatherFetchSucceed(val temperature: String) : DataEvent()
    data class OnWeatherFetchFailed(val error: Throwable):DataEvent()

}