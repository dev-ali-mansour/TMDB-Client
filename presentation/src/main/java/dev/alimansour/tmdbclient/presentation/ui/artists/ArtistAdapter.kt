package dev.alimansour.tmdbclient.presentation.ui.artists

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.alimansour.tmdbclient.R
import dev.alimansour.tmdbclient.databinding.ListItemBinding
import dev.alimansour.tmdbclient.domain.model.ArtistList.Artist
import dev.alimansour.tmdbclient.presentation.ui.artists.ArtistAdapter.ArtistViewHolder
import javax.inject.Inject

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class ArtistAdapter @Inject constructor() : RecyclerView.Adapter<ArtistViewHolder>() {
    private lateinit var context: Context
    private lateinit var artists: List<Artist>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        context = parent.context
        val binding: ListItemBinding = ListItemBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return ArtistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        val artist = artists[position]
        holder.bind(artist)
    }

    override fun getItemCount(): Int {
        return artists.size
    }

    /**
     * Set data source
     * @param artists Artist list
     */
    fun setDataSource(artists: List<Artist>) {
        this.artists = artists
        notifyDataSetChanged()
    }

    inner class ArtistViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(artist: Artist) {
            runCatching {
                binding.titleTextView.text = artist.name
                binding.descriptionTextView.text = artist.popularity.toString()
                val posterURL = context.getString(R.string.image_base_url) + artist.profilePath
                Glide.with(binding.imageView.context)
                    .load(posterURL)
                    .into(binding.imageView)
            }.onFailure { it.printStackTrace() }
        }
    }
}