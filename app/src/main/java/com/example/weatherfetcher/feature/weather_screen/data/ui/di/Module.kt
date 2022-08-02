package com.example.weatherfetcher.feature.weather_screen.data.ui.di

import com.example.weatherfetcher.*
import com.example.weatherfetcher.feature.weather_screen.data.ui.WeatherScreenViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val weatherScreenModule = module {
    /*
    presenter = WeatherScreenPresenter(
        WeatherInteractor(
            WeatherRepoImpl(
                WeatherRemoteSource(
                    WeatherApiClient.getApi()
                )
            )
        )
    )
    */


    single<OkHttpClient> { OkHttpClient.Builder().build() }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
    }

    single<WeatherApi> { get<Retrofit>().create(WeatherApi::class.java) }

    single { WeatherRemoteSource(get<WeatherApi>()) }

    single<WeatherRepo> { WeatherRepoImpl(get<WeatherRemoteSource>()) }

    single { WeatherInteractor(get<WeatherRepo>()) }

    viewModel { WeatherScreenViewModel(get<WeatherInteractor>()) }
}