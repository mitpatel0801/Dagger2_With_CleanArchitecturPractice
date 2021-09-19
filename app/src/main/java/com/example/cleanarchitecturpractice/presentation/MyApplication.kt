package com.example.cleanarchitecturpractice.presentation

import android.app.Application
import com.example.cleanarchitecturpractice.presentation.di.*

private const val BASE_URL = "https://api.themoviedb.org/3/"
private const val apiKey = "Hmm. You have to enter your own API_Key :)"

class MyApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule(BASE_URL))
            .remoteDatasourceModule(RemoteDatasourceModule(apiKey))
            .build()
    }




}