package com.afanasyeva656.weather.feature.weather_screen.domain.model

import com.afanasyeva656.weather.feature.wind_screen.domain.WindDomainModel

data class WeatherDomainModel(val temperature: String, val windDomainModel: WindDomainModel)