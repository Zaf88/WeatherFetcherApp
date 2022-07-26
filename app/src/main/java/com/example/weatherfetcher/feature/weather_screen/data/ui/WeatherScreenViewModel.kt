package com.example.weatherfetcher.feature.weather_screen.data.ui

import androidx.lifecycle.ViewModel
import com.example.weatherfetcher.base.BaseViewModel
import com.example.weatherfetcher.base.Event
import com.example.weatherfetcher.feature.weather_screen.data.WeatherInteractor

class WeatherScreenViewModel(val interactor: WeatherInteractor) : BaseViewModel<ViewState>() {

    suspend fun getWeather(): String {

        return interactor.getWeather()
   }
    override fun InitialViewState(): ViewState = ViewState(title = "hello", temperature = "")

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UIEvent.OnButtonClicked -> {
                val temperature = getWeather()
                return previousState.copy(temperature = temperature)
            }
            else -> return null
        }
    }}
