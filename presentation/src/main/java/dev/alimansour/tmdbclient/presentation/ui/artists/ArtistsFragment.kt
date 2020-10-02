package dev.alimansour.tmdbclient.presentation.ui.artists

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dev.alimansour.tmdbclient.R
import dev.alimansour.tmdbclient.presentation.ui.Injector
import javax.inject.Inject

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class ArtistsFragment : Fragment() {

    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        runCatching {
            // Inject fragment to MainComponent
            (requireActivity().application as Injector).createArtistSubComponent()
                .inject(this)
        }.onFailure { it.printStackTrace() }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        artistViewModel = ViewModelProvider(this, factory).get(ArtistViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_artists, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)

        artistViewModel.getArtists().observe(viewLifecycleOwner, {
            it?.map { artist ->
                textView.append("\nArtist: ${artist.name}")
            }
        })
        return root
    }
}