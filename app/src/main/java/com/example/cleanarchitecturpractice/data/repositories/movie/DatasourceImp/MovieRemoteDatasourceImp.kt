package com.example.cleanarchitecturpractice.data.repositories.movie.DatasourceImp

import com.example.cleanarchitecturpractice.data.api.TMDBService
import com.example.cleanarchitecturpractice.data.model.MovieList
import com.example.cleanarchitecturpractice.data.repositories.movie.Datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDatasourceImp(private val tmdbService: TMDBService,private val apiKey:String):MovieRemoteDatasource {

    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }

}