package com.example.cleanarchitecturpractice.presentation.di

import com.example.cleanarchitecturpractice.data.db.MovieDao
import com.example.cleanarchitecturpractice.data.repositories.movie.Datasource.MovieLocalDatasource
import com.example.cleanarchitecturpractice.data.repositories.movie.DatasourceImp.MovieLocalDatasourceImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDatasourceModule {

    @Singleton
    @Provides
    fun provideMovieLocalDatasource(movieDao: MovieDao):MovieLocalDatasource
    {
        return MovieLocalDatasourceImp(movieDao)
    }
}