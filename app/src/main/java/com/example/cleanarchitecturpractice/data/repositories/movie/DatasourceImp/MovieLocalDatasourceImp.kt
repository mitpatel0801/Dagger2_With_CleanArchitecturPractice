package com.example.cleanarchitecturpractice.data.repositories.movie.DatasourceImp

import com.example.cleanarchitecturpractice.data.db.MovieDao
import com.example.cleanarchitecturpractice.data.model.Movie
import com.example.cleanarchitecturpractice.data.repositories.movie.Datasource.MovieLocalDatasource

class MovieLocalDatasourceImp(private val movieDao: MovieDao) : MovieLocalDatasource {

    override suspend fun getMovies(): List<Movie> {
      return movieDao.getAllMovies()
    }

    override suspend fun addMovies(movies: List<Movie>) {
         movieDao.addAllMovies(movies)
    }

    override suspend fun deleteAllMovies() {
        movieDao.deleteAllMovies()
    }
}