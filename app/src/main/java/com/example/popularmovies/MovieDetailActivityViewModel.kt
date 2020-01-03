package com.example.popularmovies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class MovieDetailActivityViewModel(application: Application): AndroidViewModel(application) {
    val movie = MutableLiveData<Movie>()
}