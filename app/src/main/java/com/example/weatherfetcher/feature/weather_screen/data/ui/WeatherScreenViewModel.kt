package com.example.weatherfetcher.feature.weather_screen.data.ui

import android.media.metrics.Event
import androidx.lifecycle.viewModelScope
import com.example.newsfetcher.Base.BaseViewModel
import com.example.weatherfetcher.WeatherInteractor
import kotlinx.coroutines.launch
import com.example.weatherfetcher.feature.weather_screen.data.ui.UiEvent as UiEvent


abstract class WeatherScreenViewModel(val interactor: WeatherInteractor) : BaseViewModel<ViewState>() {

    override fun initialViewState(): ViewState =
        ViewState(isLoading = false, title = "Hello", temperature = "", windDeg = "")

    override fun reduce(
        event: com.example.newsfetcher.Base.Event,
        previousState: ViewState
    ): ViewState? {
        when (event) {
            is UiEvent.OnButtonClicked -> {
                viewModelScope.launch {
                    interactor.getWeather().fold(
                        onError = {
                            processDataEvent(DataEvent.OnWeatherFetchFailed(error = it))
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.OnWeatherFetchSucceed(temperature = "Температура: ${it.temperature}"))
                        }

                    )
                }

                return previousState.copy(isLoading = true)
            }

            is UiEvent.WindIsLoaded -> {
                viewModelScope.launch {
                    interactor.getWind().fold(
                        onError = {
                            processDataEvent(DataEvent.OnWeatherFetchFailed(error = it))
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.OnWindFetchSucceed(windDeg = "Направление ветра: ${it.windDeg}"))
                        }
                    )
                }
                return previousState.copy(isLoading = true)
            }
            is DataEvent.OnWeatherFetchSucceed -> {
                return previousState.copy(isLoading = false, temperature = event.temperature)
            }
            is DataEvent.OnWindFetchSucceed -> {
                return previousState.copy(isLoading = false, windDeg = event.windDeg)
            }
            else -> return null
        }
    }
}





