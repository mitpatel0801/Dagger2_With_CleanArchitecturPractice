package com.example.cleanarchitecturpractice.presentation.di

import com.example.cleanarchitecturpractice.data.api.TMDBService
import com.example.cleanarchitecturpractice.data.repositories.movie.Datasource.MovieRemoteDatasource
import com.example.cleanarchitecturpractice.data.repositories.movie.DatasourceImp.MovieRemoteDatasourceImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDatasourceModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieLocalDatasource(tmdbService: TMDBService): MovieRemoteDatasource {
        return MovieRemoteDatasourceImp(tmdbService, apiKey)
    }

}