package com.example.cleanarchitecturpractice.presentation.di

import com.example.cleanarchitecturpractice.data.repositories.movie.Datasource.MovieLocalDatasource
import com.example.cleanarchitecturpractice.data.repositories.movie.Datasource.MovieRemoteDatasource
import com.example.cleanarchitecturpractice.data.repositories.movie.MovieRepositoryImp
import com.example.cleanarchitecturpractice.domain.repositories.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDatasource,
        movieLocalDatasource: MovieLocalDatasource
    ): MovieRepository {
        return MovieRepositoryImp(movieRemoteDataSource, movieLocalDatasource)
    }
}