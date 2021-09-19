package com.example.cleanarchitecturpractice.data.model


import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val results: List<Movie>
)