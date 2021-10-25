package com.afanasyeva656.weather

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.afanasyeva656.weather.feature.weather_screen.data.storage.SettingsRepo
import com.afanasyeva656.weather.feature.weather_screen.ui.WeatherScreenActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val presenter = MainPresenter()
    //
    private val settingsRepo: SettingsRepo by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val textView = findViewById<TextView>(R.id.textView)
//        textView.text = presenter.getTemperature()
//
//        val list = listOf<Int>(1, 2, 3, 4)
//        val filteredList: List<Int>? = null
//        Log.d("test_list", "$filteredList")
//
//        filteredList?.let { textView.text = it.toString() }
//        filteredList?.let { list -> textView.text = list.toString() }
        
 //       val etCityName = findViewById<EditText>(R.id.etCityName).text


        val saveCityButton = findViewById<Button>(R.id.saveCityButton)
        saveCityButton.setOnClickListener {
            GlobalScope.launch(Dispatchers.Default) {
                settingsRepo.saveCity(findViewById<EditText>(R.id.etCityName).text.toString())
            }

        }

        val weatherButton = findViewById<Button>(R.id.weatherButton)
        weatherButton.setOnClickListener {
            Intent(this, WeatherScreenActivity::class.java).also { startActivity(it) }

        }
    }
}