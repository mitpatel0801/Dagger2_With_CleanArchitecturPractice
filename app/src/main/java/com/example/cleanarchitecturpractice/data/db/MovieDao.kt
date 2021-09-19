package com.example.cleanarchitecturpractice.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cleanarchitecturpractice.data.model.Movie

@Dao
interface MovieDao {

    @Query("SELECT * FROM Movie")
    suspend fun getAllMovies(): List<Movie>

    @Insert
    suspend fun addAllMovies(movies: List<Movie>):List<Long>

    @Query("DELETE FROM Movie")
    suspend fun deleteAllMovies()
}