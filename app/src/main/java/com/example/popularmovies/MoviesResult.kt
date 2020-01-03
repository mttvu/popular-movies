package com.example.popularmovies

import com.google.gson.annotations.SerializedName

data class MoviesResult(
    @SerializedName("results") var results: List<Movie>

    )