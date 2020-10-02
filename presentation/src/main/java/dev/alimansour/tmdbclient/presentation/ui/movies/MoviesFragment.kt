package dev.alimansour.tmdbclient.presentation.ui.movies

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dev.alimansour.tmdbclient.databinding.FragmentMoviesBinding
import dev.alimansour.tmdbclient.domain.util.ResultWrapper.Status
import dev.alimansour.tmdbclient.presentation.ui.Injector
import dev.alimansour.tmdbclient.presentation.utils.stopRefreshing
import javax.inject.Inject

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class MoviesFragment : Fragment() {
    private lateinit var binding: FragmentMoviesBinding
    private lateinit var movieViewModel: MovieViewModel

    @Inject
    lateinit var factory: MovieViewModelFactory

    @Inject
    lateinit var adapter: MovieAdapter

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
        runCatching {
            binding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
            movieViewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)

            binding.swipeRefreshLayout.setOnRefreshListener {
                binding.swipeRefreshLayout.stopRefreshing()
                updateMovies()
            }
            initRecyclerView()
        }.onFailure { it.printStackTrace() }
        return binding.root
    }

    /**
     * Initialize movies RecyclerView
     */
    private fun initRecyclerView() {
        runCatching {
            binding.apply {
                adapter.setDataSource(listOf())
                recyclerView.setHasFixedSize(true)
                recyclerView.layoutManager = LinearLayoutManager(requireContext())
                movieAdapter = adapter
                displayPopularMovies()
            }
        }.onFailure { it.printStackTrace() }
    }

    /**
     * Display popular movies
     */
    private fun displayPopularMovies() {
        runCatching {
            binding.apply {
                movieViewModel.getMovies().observe(viewLifecycleOwner, { result ->
                    when (result.status) {
                        Status.LOADING -> {
                            swipeRefreshLayout.post {
                                swipeRefreshLayout.isRefreshing = true
                            }
                        }
                        Status.ERROR -> {
                            swipeRefreshLayout.stopRefreshing()
                            Toast.makeText(requireContext(), result.message, Toast.LENGTH_LONG)
                                .show()
                        }
                        Status.SUCCESS -> {
                            swipeRefreshLayout.stopRefreshing()
                            result.data?.let { posts ->
                                adapter.setDataSource(posts)
                            }
                        }
                    }
                })
            }
        }.onFailure {
            binding.swipeRefreshLayout.stopRefreshing()
            it.printStackTrace()
        }
    }

    /**
     * Update popular movies list
     */
    private fun updateMovies() {
        runCatching {
            binding.apply {
                movieViewModel.updateMovies().observe(viewLifecycleOwner, { result ->
                    Log.d(MoviesFragment::class.simpleName, "Update movies!")
                    when (result.status) {
                        Status.LOADING -> {
                            swipeRefreshLayout.post {
                                swipeRefreshLayout.isRefreshing = true
                            }
                        }
                        Status.ERROR -> {
                            swipeRefreshLayout.stopRefreshing()
                            Toast.makeText(requireContext(), result.message, Toast.LENGTH_LONG)
                                .show()
                        }
                        Status.SUCCESS -> {
                            swipeRefreshLayout.stopRefreshing()
                            result.data?.let { posts ->
                                adapter.setDataSource(posts)
                            }
                        }
                    }
                })
            }
        }.onFailure {
            binding.swipeRefreshLayout.stopRefreshing()
            it.printStackTrace()
        }
    }
}