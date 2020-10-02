package dev.alimansour.tmdbclient.presentation.ui.artists

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.alimansour.tmdbclient.R
import dev.alimansour.tmdbclient.databinding.ListItemBinding
import dev.alimansour.tmdbclient.domain.model.ImageList.Image
import dev.alimansour.tmdbclient.presentation.ui.artists.ImageAdapter.ImageViewHolder
import javax.inject.Inject

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class ImageAdapter @Inject constructor() : RecyclerView.Adapter<ImageViewHolder>() {
    private lateinit var context: Context
    private lateinit var images: List<Image>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        context = parent.context
        val binding: ListItemBinding = ListItemBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = images[position]
        holder.bind(image)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    /**
     * Set data source
     * @param images Image list
     */
    fun setDataSource(images: List<Image>) {
        this.images = images
        notifyDataSetChanged()
    }

    inner class ImageViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(image: Image) {
            runCatching {
                binding.descriptionTextView.text = image.voteAverage.toString()
                val posterURL = context.getString(R.string.image_base_url) + image.filePath
                Glide.with(binding.imageView.context)
                    .load(posterURL)
                    .into(binding.imageView)
            }.onFailure { it.printStackTrace() }
        }
    }
}