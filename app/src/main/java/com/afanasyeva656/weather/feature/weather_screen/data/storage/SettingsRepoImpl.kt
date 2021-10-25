package com.afanasyeva656.weather.feature.weather_screen.data.storage

class SettingsRepoImpl(private val cityDataStorage: CityDataStorage) : SettingsRepo {
    override suspend fun saveCity(city: String) {
        cityDataStorage.saveCity(city)
    }

    override suspend fun getCity(): String {
        return cityDataStorage.getCity()
    }
}