package com.afanasyeva656.weather.feature

import com.afanasyeva656.weather.base.Event
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WeatherDomainModel


data class ViewState1(
    val temperature: String,
    val errorMessage: String?,

) {
    val isInErrorState: Boolean = errorMessage != null
}


sealed class UIEvent1 : Event {
    object GetCurrentWeather : UIEvent1()
}

sealed class DataEvent1 : Event {
    object OnDataLoad : DataEvent1()
    data class SuccessWeatherRequest(
        val weather: WeatherDomainModel
    ) : DataEvent1()
    data class ErrorWeatherRequest(val errorMessage: String) : DataEvent1()
}