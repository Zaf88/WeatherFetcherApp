package com.example.weatherfetcher.feature.weather_screen.data.ui

import androidx.lifecycle.viewModelScope
import com.example.weatherfetcher.Base.BaseViewModel
import com.example.weatherfetcher.Base.Event
import kotlinx.coroutines.launch


class WeatherScreenViewModel(val interactor: WeatherInteractor) : BaseViewModel<ViewState>() {


    override fun InitialViewState(): ViewState =
        ViewState(isLoading = false, title = "hello", temperature = "", isError = true, errorText ="Failed to load weather, please try again")

    override  fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UiEvent.OnButtonClicked -> {

                viewModelScope.launch {
                    interactor.getWeather().fold(
                        onError = {
                            processDataEvent(DataEvent.OnWeatherFetchError(errorText = String()))
                            },
                        onSuccess = {
                            processDataEvent(DataEvent.OnWeatherFetchSucceed(temperature = it.temperature))
                        }
                    )
                }
                return previousState.copy(isLoading = true)
            }
            is DataEvent.OnWeatherFetchSucceed -> {
                return previousState.copy(isLoading = false,temperature = event.temperature)
            }
            is DataEvent.OnWeatherFetchError -> {
                return previousState.copy(errorText = event.errorText, isError = true, isLoading = false)
            }
            else -> return null
        }
    }
}