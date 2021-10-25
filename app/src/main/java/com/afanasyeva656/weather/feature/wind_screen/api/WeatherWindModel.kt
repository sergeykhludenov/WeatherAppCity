package com.afanasyeva656.weather.feature.wind_screen.api

import com.google.gson.annotations.SerializedName

data class WeatherWindModel(
    @SerializedName("speed")
    val speed: Double,
    @SerializedName("deg")
    val deg: Int,
)


/*"wind": {
    "speed": 1.5,
    "deg": 350
},*/
