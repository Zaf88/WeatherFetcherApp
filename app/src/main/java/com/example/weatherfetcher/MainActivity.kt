package com.example.weatherfetcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.weatherfetcher.feature.weather_screen.data.WeatherApiClient
import com.example.weatherfetcher.feature.weather_screen.data.WeatherInteractor
import com.example.weatherfetcher.feature.weather_screen.data.WeatherRemoteSource
import com.example.weatherfetcher.feature.weather_screen.data.WeatherRepoImpl
import com.example.weatherfetcher.feature.weather_screen.data.ui.WeatherScreenPresenter

class MainActivity : AppCompatActivity() {

    private lateinit var presenter: WeatherScreenPresenter

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            presenter= WeatherScreenPresenter(
                WeatherInteractor(
                    WeatherRepoImpl(
                WeatherRemoteSource(WeatherApiClient.getApi())
            )))

        val textViewHello = findViewById<TextView>(R.id.tvHello)
        textViewHello.text = presenter.getWeather()
    }
}

