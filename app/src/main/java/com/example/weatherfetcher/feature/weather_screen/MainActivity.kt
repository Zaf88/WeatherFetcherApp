package com.example.weatherfetcher.feature.weather_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.weatherfetcher.R
import com.example.weatherfetcher.feature.weather_screen.data.ui.UiEvent
import com.example.weatherfetcher.feature.weather_screen.data.ui.ViewState
import com.example.weatherfetcher.feature.ui.WeatherScreenViewModel
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.abs


class MainActivity : AppCompatActivity() {

    private val viewModel: WeatherScreenViewModel by viewModel ()

    private val textViewHello: TextView by lazy { findViewById(R.id.tvHello) }
    private val fabWeather: FloatingActionButton by lazy { findViewById(R.id.fabWeatherFetch) }
    private val progressBar: ProgressBar by lazy { findViewById(R.id.progressBar) }
    private val btnWeather: Button by lazy { findViewById(R.id.btnWeather) }
    private val collapsingToolbar: CollapsingToolbarLayout by lazy { findViewById(R.id.collapsingToolbar) }
    private val weatherAppBar: AppBarLayout by lazy { findViewById(R.id.weatherAppBar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnWeather.setOnClickListener {
            val intent = Intent(this, WindActivity::class.java)
            startActivity(intent)
        }
        viewModel.viewState.observe(this, ::render)

        weatherAppBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            val percent =
                (abs(appBarLayout.totalScrollRange + verticalOffset).toFloat()/appBarLayout.totalScrollRange)
            fabWeather.alpha = percent
            Log.d("PERCENT", "$percent")
        })

        fabWeather.setOnClickListener {
            viewModel.processUiEvent(UiEvent.OnButtonClicked)
        }

    }

    private fun render(viewState: ViewState) {
        progressBar.isVisible = viewState.isLoading
        collapsingToolbar.title = viewState.temperature
        textViewHello.text = viewState.temperature
    }
}