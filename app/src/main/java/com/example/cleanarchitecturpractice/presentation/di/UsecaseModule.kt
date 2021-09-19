package com.example.cleanarchitecturpractice.presentation.di


import com.example.cleanarchitecturpractice.domain.repositories.MovieRepository
import com.example.cleanarchitecturpractice.domain.usecases.GetMoviesUseCase
import com.example.cleanarchitecturpractice.domain.usecases.UpdateMovieUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UsecaseModule {

    @Singleton
    @Provides
    fun provideGetMovieUsecase(
        movieRepository: MovieRepository
    ): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateMovieUsecase(
        movieRepository: MovieRepository
    ): UpdateMovieUseCase {
        return UpdateMovieUseCase(movieRepository)
    }
}