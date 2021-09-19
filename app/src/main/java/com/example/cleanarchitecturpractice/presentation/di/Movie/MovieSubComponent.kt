package com.example.cleanarchitecturpractice.presentation.di.Movie

import com.example.cleanarchitecturpractice.presentation.activities.MainActivity
 import dagger.Subcomponent


@MovieScope
@Subcomponent(modules = [MovieViewModelFactoryModule::class])
interface MovieSubComponent {

    fun inject(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }

}