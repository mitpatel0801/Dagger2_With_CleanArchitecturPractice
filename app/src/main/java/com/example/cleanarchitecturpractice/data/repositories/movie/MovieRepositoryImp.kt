package com.example.cleanarchitecturpractice.data.repositories.movie

import android.util.Log
import com.example.cleanarchitecturpractice.data.model.Movie
import com.example.cleanarchitecturpractice.data.repositories.movie.Datasource.MovieLocalDatasource
import com.example.cleanarchitecturpractice.data.repositories.movie.Datasource.MovieRemoteDatasource
import com.example.cleanarchitecturpractice.domain.repositories.MovieRepository
import java.lang.Exception

class MovieRepositoryImp(
    private val movieRemoteDataSource: MovieRemoteDatasource,
    private val movieLocalDatasource: MovieLocalDatasource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie> {
        return getMovieFromdb()
    }

    private suspend fun getMovieFromdb(): List<Movie> {

        var movies = movieLocalDatasource.getMovies()


        if (movies.isEmpty()) {
            movies = getMoviesFromApi()
            movieLocalDatasource.addMovies(movies)
        }

        return movies
    }

    private suspend fun getMoviesFromApi(): List<Movie> {

        lateinit var movieList: List<Movie>

        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()

            if (body != null) {
                movieList = body.results
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return movieList
    }

    override suspend fun updateMovies(): List<Movie> {
        val movies = getMoviesFromApi()
        movieLocalDatasource.deleteAllMovies()
        movieLocalDatasource.addMovies(movies)
        return movies
    }


}