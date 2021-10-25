package com.afanasyeva656.weather.feature.weather_screen.domain

import com.afanasyeva656.weather.feature.weather_screen.data.api.WeatherRepo
import com.afanasyeva656.weather.feature.weather_screen.data.storage.SettingsRepo
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WeatherDomainModel

// можем объединить тут несколько репозиториев
class WeatherInteractor(private val repository: WeatherRepo, private val settingRepo: SettingsRepo) {
    suspend fun getWeather(): WeatherDomainModel {
        return repository.getWeather(settingRepo.getCity())
    }

}