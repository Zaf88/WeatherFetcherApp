package com.example.weatherfetcher

import android.app.Application
import com.example.weatherfetcher.feature.weather_screen.data.ui.di.weatherScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class App {

    class App : Application() {
        override fun onCreate() {
            super.onCreate()
            // Start Koin
            startKoin {
                androidLogger()
                androidContext(this@App)
                modules(weatherScreenModule)
            }
        }
    }
}