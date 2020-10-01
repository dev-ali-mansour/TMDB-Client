package dev.alimansour.tmdbclient.presentation.ui.artists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dev.alimansour.tmdbclient.R

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class ArtistsFragment : Fragment() {

    private lateinit var artistsViewModel: ArtistsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        artistsViewModel =
            ViewModelProvider(this).get(ArtistsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_artists, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        artistsViewModel.text.observe(viewLifecycleOwner, { textView.text = it })
        return root
    }
}