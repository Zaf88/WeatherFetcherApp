package com.example.weatherfetcher.feature.weather_screen.data.ui

import com.example.weatherfetcher.base.Event

data class ViewState(
    val title:String,
    val temperature:String
)
sealed class UIEvent:Event{
    object OnButtonClicked:UIEvent()
}