package dev.alimansour.tmdbclient.presentation.ui.movies

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
class MoviesFragment : Fragment() {

    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        runCatching {
            // Inject fragment to MainComponent
            (requireActivity().application as Injector).createMovieSubComponent()
                .inject(this)
        }.onFailure { it.printStackTrace() }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        movieViewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_movies, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        movieViewModel.getMovies().observe(viewLifecycleOwner, {
            it?.map { movie ->
                textView.append("\nMovie: ${movie.title}")
            }
        })
        return root
    }
}