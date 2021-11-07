package com.afanasyeva656.weather.feature.wind_screen.ui

import com.afanasyeva656.weather.base.Event
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WeatherDomainModel
import com.afanasyeva656.weather.feature.wind_screen.domain.WindDomainModel

data class ViewState2(
    val degree: Int,
    val errorMessage: String?,

    ) {
    val isInErrorState: Boolean = errorMessage != null
}


sealed class UIEvent2 : Event {
    object GetCurrentWind : UIEvent2()
}

sealed class DataEvent2 : Event {
    object OnDataLoad : DataEvent2()
    data class SuccessWindRequest(
        val wind: WeatherDomainModel
    ) : DataEvent2()
    data class ErrorWindRequest(val errorMessage: String) : DataEvent2()
}