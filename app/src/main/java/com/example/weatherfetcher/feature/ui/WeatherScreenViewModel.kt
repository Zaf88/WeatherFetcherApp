package com.example.weatherfetcher.feature.ui

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.weatherfetcher.Base.BaseViewModel
import com.example.weatherfetcher.Base.Event
import com.example.weatherfetcher.feature.weather_screen.WeatherInteractor
import com.example.weatherfetcher.feature.weather_screen.data.ui.DataEvent
import com.example.weatherfetcher.feature.weather_screen.data.ui.ViewState
import kotlinx.coroutines.launch
import com.example.weatherfetcher.feature.weather_screen.data.ui.UiEvent as UiEvent

//class WeatherScreenViewModel(val interactor: WeatherInteractor) : BaseViewModel<ViewState>() {
//
//    override fun InitialViewState(): ViewState =
//        ViewState(isLoading = false, title = "Hello", temperature = "", windDeg = "")
//
//    override fun reduce(event: Event, previousState: ViewState): ViewState? {
//        when (event) {
//            is UiEvent.OnButtonClicked -> {
//                viewModelScope.launch {
//                    interactor.getWeather().fold(
//                        onError = {
//                            processDataEvent(DataEvent.OnWeatherFetchFailed(error = it))
//                            it.localizedMessage?.let { it1 -> Log.e("ERROR", it1) }
//                        },
//                        onSuccess = {
//                            processDataEvent(DataEvent.OnWeatherFetchSucceed(temperature = "Температура: ${it.temperature}"))
//                        }
//
//                    )
//                }
//
//                return previousState.copy(isLoading = true )
//            }
//
//            is UiEvent.WindIsLoaded -> {
//                viewModelScope.launch {
//                    interactor.getWind().fold(
//                        onError = {
//                            processDataEvent(DataEvent.OnWeatherFetchFailed(error = it))
//                        },
//                        onSuccess = {
//                            processDataEvent(DataEvent.OnWindFetchSucceed(windDeg = "Направление ветра: ${it.windDeg}"))
//                        }
//                    )
//                }
//                return previousState.copy(isLoading = true)
//            }
//            is DataEvent.OnWeatherFetchSucceed -> {
//                return previousState.copy(isLoading = false, temperature = event.temperature)
//            }
//            is DataEvent.OnWindFetchSucceed -> {
//                return previousState.copy(isLoading = false, windDeg = event.windDeg)
//            }
//            else -> return null
//        }
//    }
//}
//

class WeatherScreenViewModel(val interactor: WeatherInteractor) : BaseViewModel<ViewState>() {

    fun initialViewState(): ViewState =
        ViewState(
            descriptionCurrent = "",
            iconCurrent = "",
            tempCurrent = "          --",
            windDegCurrent = "   --",
            city = "---",
            isSearchVisible = false,
            weatherHourForecastList = emptyList(),
            weatherDayForecastList = emptyList()
        )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {

            is DataEvent.WeatherIsLoaded -> {
                viewModelScope.launch {
                    interactor.getWeather(event.city).fold(
                        onError = {
                            processDataEvent(DataEvent.OnWeatherFetchFailed(error = it))
                        },
                        onSuccess = {
                            processDataEvent(
                                DataEvent.OnWeatherFetchSucceed(
                                    weatherHourForecastList = it,
                                    city = event.city
                                )
                            )
                        }

                    )
                }

                return previousState.copy()
            }

            is DataEvent.OnWeatherFetchSucceed -> {
                return previousState.copy(
                    weatherHourForecastList = event.weatherHourForecastList.slice(0..12),
                    city = event.city,
                    descriptionCurrent = event.weatherHourForecastList[0].description,
                    iconCurrent = event.weatherHourForecastList[0].icon,
                    tempCurrent = "${
                        event.weatherHourForecastList[0].temperature.toInt().toString()
                    }°C",
                    windDegCurrent = event.weatherHourForecastList[0].windDeg,
                    weatherDayForecastList =
                    event.weatherHourForecastList
                        .slice(0..event.weatherHourForecastList.size step 12)
                )
            }
            is UiEvent.isSearchClicked -> {
                return previousState.copy(
                    isSearchVisible = !previousState.isSearchVisible
                )
            }

            else -> return null
        }

    }

    override fun InitialViewState(): ViewState {
        TODO("Not yet implemented")
    }
}









