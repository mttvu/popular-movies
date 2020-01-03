package com.example.popularmovies

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.text.SimpleDateFormat
import java.util.*

@Parcelize

data class Movie(
    @SerializedName("title") var title: String,
    @SerializedName("release_date") var date: Date,
    @SerializedName("vote_average") var rating: Double,
    @SerializedName("overview") var overview: String,
    @SerializedName("poster_path") var posterUrl: String,
    @SerializedName("backdrop_path") var backdropUrl: String
    ): Parcelable {
    fun getPosterImage () = "https://image.tmdb.org/t/p/w500$posterUrl"

    fun getBackdropImage () = "https://image.tmdb.org/t/p/w500$backdropUrl"

    fun getSimpleDate (date: Date) : String {
        val format = SimpleDateFormat("yyyy-MM-dd")
        return format.format(date)
    }

}