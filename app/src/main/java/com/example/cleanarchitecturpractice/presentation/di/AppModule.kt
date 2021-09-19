package com.example.cleanarchitecturpractice.presentation.di

import android.content.Context
import com.example.cleanarchitecturpractice.presentation.di.Movie.MovieSubComponent
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class])
class AppModule (private val context: Context){

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }

}