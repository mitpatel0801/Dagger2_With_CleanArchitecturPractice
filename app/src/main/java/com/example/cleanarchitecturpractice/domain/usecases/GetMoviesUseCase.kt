package com.example.cleanarchitecturpractice.domain.usecases

import com.example.cleanarchitecturpractice.domain.repositories.MovieRepository

class GetMoviesUseCase(private val movieRepo: MovieRepository) {

    suspend fun execute() = movieRepo.getMovies()
}