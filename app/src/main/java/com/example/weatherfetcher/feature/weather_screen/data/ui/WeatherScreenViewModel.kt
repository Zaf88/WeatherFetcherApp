package com.example.weatherfetcher.feature.weather_screen.data.ui

import androidx.lifecycle.viewModelScope
import com.example.weatherfetcher.base.BaseViewModel
import com.example.weatherfetcher.base.Event
import com.example.weatherfetcher.feature.weather_screen.data.WeatherInteractor
import kotlinx.coroutines.launch

class WeatherScreenViewModel(val interactor: WeatherInteractor) : BaseViewModel<ViewState>() {

    override fun InitialViewState(): ViewState =
        ViewState(isLoading = false, title = "hello", temperature = "")

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UIEvent.OnButtonClicked -> {
                viewModelScope.launch {
                    interactor.getWeather().fold(
                        onError = {
                            processDataEvent(DataEvent.OnWeatherFetchFailed(error = it))
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.OnWeatherFetchSucceed(temperature = it.temperature))
                        }
                    )
                }

            return previousState.copy(isLoading = true)
        }
            is DataEvent.OnWeatherFetchSucceed->{
                return previousState.copy(isLoading = false, temperature = event.temperature)
            }
           else -> return null
        }
    }}
