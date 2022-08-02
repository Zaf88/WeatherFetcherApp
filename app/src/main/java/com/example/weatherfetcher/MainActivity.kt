package com.example.weatherfetcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.weatherfetcher.feature.weather_screen.data.ui.UiEvent
import com.example.weatherfetcher.feature.weather_screen.data.ui.ViewState
import com.example.weatherfetcher.feature.weather_screen.data.ui.WeatherScreenViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.androidx.viewmodel.ext.android.viewModel



class MainActivity : AppCompatActivity() {

    private val viewModel: WeatherScreenViewModel by viewModel()

    private val textViewHello: TextView by lazy { findViewById(R.id.tvHello) }
    private val fabWatcher: FloatingActionButton by lazy { findViewById(R.id.fabWeatherFetch) }
    private val progressBar: ProgressBar by lazy { findViewById(R.id.progressBar) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnWind = findViewById<Button>(R.id.btnWind)
        btnWind.setOnClickListener {
            val intent = Intent(this, WindActivity::class.java)
            startActivity(intent)
        }
        viewModel.viewState.observe(this, ::render)

        fabWatcher.setOnClickListener {
            viewModel.processUiEvent(UiEvent.WindIsLoaded)
        }


    }

    private fun render(viewState: ViewState) {
        progressBar.isVisible = viewState.isLoading
        textViewHello.text = "${viewState.title} ${viewState.temperature}"
    }
}