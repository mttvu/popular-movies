package com.example.popularmovies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListActivityViewModel (application: Application): AndroidViewModel(application){
    private val movieRepository = MovieRepository()
    val movies = MutableLiveData<MoviesResult>()
    val error = MutableLiveData<String>()

    fun getMovieList(year: String) {
        movieRepository.getMovieList(year).enqueue(object : Callback<MoviesResult> {
            override fun onResponse(call: Call<MoviesResult>, response: Response<MoviesResult>) {
                if (response.isSuccessful){
                    movies.value = response.body()}
                else error.value = "An error occurred: ${response.errorBody().toString()}"
            }

            override fun onFailure(call: Call<MoviesResult>, t: Throwable) {
                error.value = t.message
            }
        })
    }
}