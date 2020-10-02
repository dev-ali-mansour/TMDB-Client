package dev.alimansour.tmdbclient.presentation.ui.tvshows

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.alimansour.tmdbclient.R
import dev.alimansour.tmdbclient.databinding.ListItemBinding
import dev.alimansour.tmdbclient.domain.model.TvShowList.TvShow
import dev.alimansour.tmdbclient.presentation.ui.tvshows.TVShowAdapter.TVShowViewHolder
import javax.inject.Inject

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class TVShowAdapter @Inject constructor() : RecyclerView.Adapter<TVShowViewHolder>() {
    private lateinit var context: Context
    private lateinit var tvShows: List<TvShow>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        context = parent.context
        val binding: ListItemBinding = ListItemBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return TVShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        val tvShow = tvShows[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int {
        return tvShows.size
    }

    /**
     * Set data source
     * @param tvShows TVShow list
     */
    fun setDataSource(tvShows: List<TvShow>) {
        this.tvShows = tvShows
        notifyDataSetChanged()
    }

    inner class TVShowViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(tvshow: TvShow) {
            runCatching {
                binding.titleTextView.text = tvshow.name
                binding.descriptionTextView.text = tvshow.overview
                val posterURL = context.getString(R.string.image_base_url) + tvshow.posterPath
                Glide.with(binding.imageView.context)
                    .load(posterURL)
                    .into(binding.imageView)
            }.onFailure { it.printStackTrace() }
        }
    }
}