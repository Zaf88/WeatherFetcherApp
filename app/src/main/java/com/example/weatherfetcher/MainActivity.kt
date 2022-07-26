package com.example.weatherfetcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.weatherfetcher.feature.weather_screen.data.ui.UIEvent
import com.example.weatherfetcher.feature.weather_screen.data.ui.ViewState
import com.example.weatherfetcher.feature.weather_screen.data.ui.WeatherScreenViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: WeatherScreenViewModel by viewModel()
    private val textViewHello: TextView by lazy { findViewById<TextView>(R.id.tvHello) }
    private val fabWeather: FloatingActionButton by lazy { findViewById(R.id.fabWeatherFetch) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.viewState.observe(this,::render)
        fabWeather.setOnClickListener {
            viewModel.processUIEvent(UIEvent.OnButtonClicked)
        }
    }

    private fun render(viewState: ViewState) {
        textViewHello.text= "${viewState.title} ${viewState.temperature}"

    }
}



