package com.example.cleanarchitecturpractice.presentation.viewmodels.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecturpractice.domain.usecases.GetMoviesUseCase
import com.example.cleanarchitecturpractice.domain.usecases.UpdateMovieUseCase
import java.lang.IllegalArgumentException

class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            return MovieViewModel(getMoviesUseCase, updateMovieUseCase) as T
        }

        throw IllegalArgumentException("Wrong ViewModel")
    }

}