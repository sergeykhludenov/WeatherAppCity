package com.afanasyeva656.weather.feature.wind_screen.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer

import com.afanasyeva656.weather.R
import com.afanasyeva656.weather.feature.weather_screen.domain.model.WeatherDomainModel
import org.koin.android.viewmodel.ext.android.viewModel

class WindScreenActivity : AppCompatActivity() {
    val windScreenViewModel by viewModel<WindScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wind)
        windScreenViewModel.viewState.observe(this, Observer(::render))
       //windScreenViewModel.requestWind()

    }

    private fun render(model: ViewState2) {
        findViewById<TextView>(R.id.tvWindDegree).let { it.text = model.degree.toString() }
    }
}