package com.example.weatherfetcher.feature.weather_screen.data.ui

import com.example.weatherfetcher.Base.BaseViewModel
import com.example.weatherfetcher.Base.Event


class WeatherScreenViewModel(val interactor: WeatherInteractor) : BaseViewModel<ViewState>() {

    suspend fun getWeather(): String {
        return interactor.getWeather()
    }

    override fun InitialViewState(): ViewState  = ViewState(title = "hello", temperature = "")

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UiEvent.OnButtonClicked -> {
                val temperature = getWeather()
                return previousState.copy(temperature = temperature)
            }
            else -> return null
        }
    }
}