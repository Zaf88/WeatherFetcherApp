package com.example.weatherfetcher.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


abstract class BaseViewModel<VIEW_STATE> : ViewModel() {

    val viewState: MutableLiveData<VIEW_STATE> by lazy { MutableLiveData(InitialViewState()) }

    abstract fun InitialViewState(): VIEW_STATE
    abstract fun reduce(event: Event, previousState: VIEW_STATE): VIEW_STATE?

    fun processUIEvent(event: Event) {
        updateState(event)
    }

    protected fun processDataEvent(event: Event) {
        updateState(event)
    }

    private fun updateState(event: Event) {
        val newViewState = reduce(event, viewState.value ?: InitialViewState())
        if (newViewState != null && newViewState != viewState.value) {
            viewState.value = newViewState
        }
    }


}
