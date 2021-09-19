package com.example.cleanarchitecturpractice.data.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cleanarchitecturpractice.data.model.Movie

@Database(entities = [Movie::class], version = 1)
abstract class TMDBDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}