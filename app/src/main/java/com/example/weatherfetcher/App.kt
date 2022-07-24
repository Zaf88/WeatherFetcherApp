package com.example.weatherfetcher

import android.app.Application
import com.example.weatherfetcher.feature.weather_screen.data.di.WeatherScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.koinApplication

class App: Application() {

    override fun onCreate() {
        super.onCreate()
    startKoin{
        androidLogger()
        androidContext(this@App)
        modules(WeatherScreenModule)
    }

    }
}