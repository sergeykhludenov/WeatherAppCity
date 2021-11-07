package com.afanasyeva656.weather.feature.wind_screen.ui

import com.afanasyeva656.weather.feature.weather_screen.domain.WeatherInteractor
import com.afanasyeva656.weather.base.BaseViewModel
import com.afanasyeva656.weather.base.Event
import com.afanasyeva656.weather.feature.wind_screen.domain.WindDomainModel


/*
class WindScreenViewModel(private val weatherInteractor: WeatherInteractor) : BaseViewModel<ViewState2>() {
}
*/

class WindScreenViewModel(private val weatherInteractor: WeatherInteractor) : BaseViewModel<ViewState2>() {

    init {
        processUiEvent(UIEvent2.GetCurrentWind)
    }


    override fun initialViewState(): ViewState2 {
        return ViewState2(
            errorMessage = null,
            degree = 0,
        )
    }

    override suspend fun reduce(event: Event, previousState: ViewState2): ViewState2? {
        when (event) {
            is DataEvent2.SuccessWindRequest -> {
                return previousState.copy(
                    degree = event.wind.windDomainModel.degree,
                    errorMessage = null,
                )
            }
            is DataEvent2.ErrorWindRequest -> {
                return previousState.copy(
                    errorMessage = event.errorMessage
                )
            }
            is UIEvent2.GetCurrentWind -> {
                weatherInteractor.getWeather().fold(
                    onError = {
                        processDataEvent(DataEvent2.ErrorWindRequest(it.localizedMessage ?: ""))
                    },
                    onSuccess = {
                        processDataEvent(DataEvent2.SuccessWindRequest(it))
                    }
                )
            }
        }
        return null
    }
}


/*    val liveData: MutableLiveData<WeatherDomainModel> = MutableLiveData()

    fun requestWind() {
        viewModelScope.launch {
            liveData.postValue(weatherInteractor.getWeather())
        }
    }*/


