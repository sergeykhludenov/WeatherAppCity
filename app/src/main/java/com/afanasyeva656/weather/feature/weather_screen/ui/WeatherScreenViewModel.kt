package com.afanasyeva656.weather.feature.weather_screen.ui

import com.afanasyeva656.weather.base.BaseViewModel
import com.afanasyeva656.weather.base.Event
import com.afanasyeva656.weather.feature.DataEvent1
import com.afanasyeva656.weather.feature.UIEvent1
import com.afanasyeva656.weather.feature.ViewState1

import com.afanasyeva656.weather.feature.weather_screen.domain.WeatherInteractor

class WeatherScreenViewModel(private val weatherInteractor: WeatherInteractor) : BaseViewModel<ViewState1>(){

    init {
        processUiEvent(UIEvent1.GetCurrentWeather)
    }


    override fun initialViewState(): ViewState1 {
        return ViewState1(
            errorMessage = null,
            temperature = "Not defined",
        )
    }

    override suspend fun reduce(event: Event, previousState: ViewState1): ViewState1? {
        when (event) {
            is DataEvent1.SuccessWeatherRequest -> {
                return previousState.copy(
                    temperature = event.weather.temperature,
                    errorMessage = null,
                )
            }
            is DataEvent1.ErrorWeatherRequest -> {
                return previousState.copy(
                    errorMessage = event.errorMessage
                )
            }
            is UIEvent1.GetCurrentWeather -> {
                weatherInteractor.getWeather().fold(
                    onError = {
                        processDataEvent(DataEvent1.ErrorWeatherRequest(it.localizedMessage ?: ""))
                    },
                    onSuccess = {
                        processDataEvent(DataEvent1.SuccessWeatherRequest(it))
                    }
                )
            }
        }
        return null
    }

/*    fun requestWeather() {
        viewModelScope.launch {
            liveData.postValue(weatherInteractor.getWeather())
        }
    }*/
}