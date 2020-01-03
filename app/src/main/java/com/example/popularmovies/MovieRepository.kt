package com.example.popularmovies

class MovieRepository {
    private val movieApi: MovieApiService = MovieApi.createApi()

    fun getMovieList(year: String) = movieApi.getMovieList(year)
}