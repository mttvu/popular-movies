package com.example.popularmovies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movielist_item.view.*

class MovieAdapter(private val movies: List<Movie>, private val onClick: (Movie) -> Unit):
    RecyclerView.Adapter<MovieAdapter.ViewHolder>(){
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.movielist_item, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(movies[position], position)
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener { onClick(movies[adapterPosition]) }
        }
        fun bind(movie: Movie, position: Int) {
            var listNumber = position + 1
            itemView.tvNumber.text = context.getString(R.string.list_number, listNumber)
            Glide.with(context).load(movie.getPosterImage()).into(itemView.ivPoster)
        }

    }
}