package dev.alimansour.tmdbclient.presentation.ui.movies

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.alimansour.tmdbclient.R
import dev.alimansour.tmdbclient.databinding.ListItemBinding
import dev.alimansour.tmdbclient.domain.model.MovieList.Movie
import dev.alimansour.tmdbclient.presentation.ui.movies.MovieAdapter.MovieViewHolder
import javax.inject.Inject

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class MovieAdapter @Inject constructor() : RecyclerView.Adapter<MovieViewHolder>() {
    private lateinit var context: Context
    private lateinit var movies: List<Movie>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        context = parent.context
        val binding: ListItemBinding = ListItemBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    /**
     * Set data source
     * @param movies Movie list
     */
    fun setDataSource(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            runCatching {
                binding.titleTextView.text = movie.title
                binding.descriptionTextView.text = movie.overview
                val posterURL = context.getString(R.string.image_base_url) + movie.posterPath
                Glide.with(binding.imageView.context)
                    .load(posterURL)
                    .into(binding.imageView)
            }.onFailure { it.printStackTrace() }
        }
    }
}