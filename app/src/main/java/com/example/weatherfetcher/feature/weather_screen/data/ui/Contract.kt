package com.example.weatherfetcher.feature.weather_screen.data.ui

import com.example.weatherfetcher.Base.Event


data class ViewState(
    val title: String,
    val temperature: String
)

sealed class UiEvent : Event {
    object OnButtonClicked : UiEvent()

}
