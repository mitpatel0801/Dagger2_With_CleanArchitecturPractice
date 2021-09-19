package com.example.cleanarchitecturpractice.presentation.di

import android.content.Context
import androidx.room.Room
import com.example.cleanarchitecturpractice.data.db.MovieDao
import com.example.cleanarchitecturpractice.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideTMDBDatabase(context: Context):TMDBDatabase
    {
       return Room.databaseBuilder(
            context,
            TMDBDatabase::class.java, "tmdb_client"
        ).build()
    }

    @Singleton
    @Provides
    fun provideTMDBDao(tmdbDatabase: TMDBDatabase):MovieDao
    {
        return tmdbDatabase.movieDao()
    }

}