package com.example.cleanarchitecturpractice.domain.repositories

import com.example.cleanarchitecturpractice.data.model.Movie

interface MovieRepository {
   suspend fun getMovies():List<Movie>?
   suspend fun updateMovies():List<Movie>?
}