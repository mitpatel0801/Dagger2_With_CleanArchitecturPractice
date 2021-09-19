package com.example.cleanarchitecturpractice.presentation.di

import com.example.cleanarchitecturpractice.presentation.activities.MainActivity
import com.example.cleanarchitecturpractice.presentation.di.Movie.MovieSubComponent
import com.example.cleanarchitecturpractice.presentation.di.Movie.MovieViewModelFactoryModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        DatabaseModule::class,
        LocalDatasourceModule::class,
        NetworkModule::class,
        RemoteDatasourceModule::class,
        RepositoryModule::class,
        UsecaseModule::class
    ]
)
interface AppComponent {

    fun movieSubcomponent():MovieSubComponent.Factory

}