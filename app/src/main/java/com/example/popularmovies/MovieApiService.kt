package com.example.popularmovies

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    // The GET method needed to retrieve a list of popular movies of a specific year.
    @GET("/3/discover/movie?api_key=ceba230d388c3f2f7269839d2fcd8e6f&language=en-US&sort_by=popularity.desc")
    fun getMovieList(@Query("primary_release_year") year: String): Call<MoviesResult>
}