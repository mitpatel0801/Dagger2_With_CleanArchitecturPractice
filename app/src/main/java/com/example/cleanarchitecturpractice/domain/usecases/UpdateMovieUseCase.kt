package com.example.cleanarchitecturpractice.domain.usecases

import com.example.cleanarchitecturpractice.domain.repositories.MovieRepository

class UpdateMovieUseCase(private val movieRepo: MovieRepository) {

    suspend fun execute() = movieRepo.updateMovies()
}