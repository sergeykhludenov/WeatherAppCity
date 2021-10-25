package com.afanasyeva656.weather.feature.weather_screen.data

import com.afanasyeva656.weather.feature.weather_screen.data.api.model.WeatherModel
import com.afanasyeva656.weather.feature.wind_screen.api.WeatherWindModel
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WeatherDomainModel
import com.afanasyeva656.weather.feature.wind_screen.domain.WindDomainModel

fun WeatherModel.toDomain() = WeatherDomainModel(
    temperature = main.temp,
    windDomainModel = wind.toDomain()
)

fun WeatherWindModel.toDomain() = WindDomainModel(
    speed = speed,
    degree = deg

)
