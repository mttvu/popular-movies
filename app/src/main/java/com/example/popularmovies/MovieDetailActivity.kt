package com.example.popularmovies

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide

import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.content_movie_detail.*
import kotlinx.android.synthetic.main.movielist_item.view.*


class MovieDetailActivity : AppCompatActivity() {
    private lateinit var movieDetailActivityViewModel: MovieDetailActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        setSupportActionBar(toolbar)
        initViewModel()
        initViews()
    }

    private fun initViews(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun initViewModel(){
        movieDetailActivityViewModel = ViewModelProviders.of(this).get(MovieDetailActivityViewModel::class.java)
        movieDetailActivityViewModel.movie.value = intent.extras?.getParcelable(MOVIE_EXTRA)!!
        movieDetailActivityViewModel.movie.observe(this, Observer { movie ->
            if (movie != null) {
                tvTitle.text = movie.title
                tvRelease.text = movie.getSimpleDate(movie.date)
                tvOverview.text = movie.overview
                tvRating.text = movie.rating.toString()
                Glide.with(this).load(movie.getPosterImage()).into(ivPoster)
                Glide.with(this).load(movie.getBackdropImage()).into(ivBackdrop)
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }


    companion object {
        const val MOVIE_EXTRA = "MOVIE_EXTRA"
    }

}
