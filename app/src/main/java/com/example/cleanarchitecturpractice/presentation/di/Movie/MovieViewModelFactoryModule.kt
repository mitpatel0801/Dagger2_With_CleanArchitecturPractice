package com.example.cleanarchitecturpractice.presentation.di.Movie

import com.example.cleanarchitecturpractice.domain.usecases.GetMoviesUseCase
import com.example.cleanarchitecturpractice.domain.usecases.UpdateMovieUseCase
import com.example.cleanarchitecturpractice.presentation.viewmodels.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class MovieViewModelFactoryModule {

    @Provides
    @MovieScope
    fun provideViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMovieUseCase: UpdateMovieUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMovieUseCase)
    }
}