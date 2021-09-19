package com.example.cleanarchitecturpractice.data.repositories.movie.Datasource

import com.example.cleanarchitecturpractice.data.model.Movie

interface MovieLocalDatasource {
    suspend fun getMovies(): List<Movie>
    suspend fun addMovies(movies: List<Movie>)
    suspend fun deleteAllMovies()
}