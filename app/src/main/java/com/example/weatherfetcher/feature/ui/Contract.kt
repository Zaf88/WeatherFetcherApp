package com.example.weatherfetcher.feature.weather_screen.data.ui

import com.example.weatherfetcher.Base.Event
import com.example.weatherfetcher.feature.data.WeatherMainModel


//data class ViewState(
//    val isLoading: Boolean,
//    val title: String,
//    val temperature: String,
//    val windDeg: String
//
//)
//
//sealed class UiEvent() : Event {
//    object OnButtonClicked : UiEvent()
//    object WindIsLoaded : UiEvent()
//   }
//
//sealed class DataEvent : Event {
//    data class OnWeatherFetchSucceed(val temperature: String) : DataEvent()
//    data class OnWindFetchSucceed(val windDeg: String) : DataEvent()
//    data class OnWeatherFetchFailed(val error: Throwable) : DataEvent()
//}

data class ViewState(
    val descriptionCurrent: String,
    val iconCurrent: String,
    val tempCurrent: String,
    val windDegCurrent: String,
    val city: String,
    var isSearchVisible: Boolean,
    val weatherHourForecastList: List<WeatherMainModel>,
    val weatherDayForecastList: List<WeatherMainModel>
)

sealed class UiEvent : Event {
    object isSearchClicked : UiEvent()

}

sealed class DataEvent : Event {
    data class OnWeatherFetchSucceed(
        val weatherHourForecastList: List<WeatherMainModel>,
        val city: String
    ) :
        DataEvent()

    data class OnWeatherFetchFailed(val error: Throwable) : DataEvent()
    data class WeatherIsLoaded(val city: String) : DataEvent()

}
