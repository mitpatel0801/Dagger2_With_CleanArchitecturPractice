package com.example.cleanarchitecturpractice.presentation.viewmodels.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.cleanarchitecturpractice.domain.usecases.GetMoviesUseCase
import com.example.cleanarchitecturpractice.domain.usecases.UpdateMovieUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
) : ViewModel() {


    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMovieUseCase.execute()
        emit(movieList)
    }

}