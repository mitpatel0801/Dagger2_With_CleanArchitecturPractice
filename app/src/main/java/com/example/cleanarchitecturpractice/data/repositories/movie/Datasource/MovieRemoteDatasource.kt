package com.example.cleanarchitecturpractice.data.repositories.movie.Datasource

import com.example.cleanarchitecturpractice.data.model.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies():Response<MovieList>
}