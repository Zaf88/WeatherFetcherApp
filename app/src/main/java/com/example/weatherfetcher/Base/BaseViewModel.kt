package com.example.weatherfetcher.Base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherfetcher.feature.weather_screen.data.ui.DataEvent
import kotlinx.coroutines.launch


abstract class BaseViewModel<VIEW_STATE> : ViewModel() {

    val viewState: MutableLiveData<VIEW_STATE> by lazy { MutableLiveData(InitialViewState()) }

    abstract fun InitialViewState(): VIEW_STATE
    abstract  fun reduce(event: Event, previousState: VIEW_STATE): VIEW_STATE?

     fun processUiEvent(event: Event) {
        updateState(event)
    }

    protected fun processDataEvent(event: Event) {
        updateState(event)
    }

    private  fun updateState(event: Event) {
        val newViewState = reduce(event, viewState.value ?: InitialViewState())
        if (newViewState != null && newViewState != viewState.value) {
            viewState.value = newViewState
        }
    }
}
