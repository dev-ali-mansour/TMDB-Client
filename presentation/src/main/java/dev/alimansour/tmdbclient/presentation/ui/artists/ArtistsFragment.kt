package dev.alimansour.tmdbclient.presentation.ui.artists

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dev.alimansour.tmdbclient.databinding.FragmentArtistsBinding
import dev.alimansour.tmdbclient.domain.util.ResultWrapper
import dev.alimansour.tmdbclient.presentation.ui.Injector
import dev.alimansour.tmdbclient.presentation.util.startRefreshing
import dev.alimansour.tmdbclient.presentation.util.stopRefreshing
import javax.inject.Inject

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class ArtistsFragment : Fragment() {
    private lateinit var binding: FragmentArtistsBinding
    private lateinit var artistViewModel: ArtistViewModel

    @Inject
    lateinit var factory: ArtistViewModelFactory

    @Inject
    lateinit var adapter: ArtistAdapter

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
        runCatching {
            binding = FragmentArtistsBinding.inflate(layoutInflater, container, false)
            artistViewModel = ViewModelProvider(this, factory).get(ArtistViewModel::class.java)

            binding.swipeRefreshLayout.setOnRefreshListener {
                binding.swipeRefreshLayout.isRefreshing = false
                updateArtists()
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
                artistAdapter = adapter
                displayPopularArtists()
            }
        }.onFailure { it.printStackTrace() }
    }

    /**
     * Display popular artists
     */
    private fun displayPopularArtists() {
        runCatching {
            binding.apply {
                artistViewModel.getArtists().observe(viewLifecycleOwner, { result ->
                    when (result.status) {
                        ResultWrapper.Status.LOADING -> {
                            swipeRefreshLayout.startRefreshing()
                        }
                        ResultWrapper.Status.ERROR -> {
                            swipeRefreshLayout.stopRefreshing()
                            Toast.makeText(requireContext(), result.message, Toast.LENGTH_LONG)
                                .show()
                        }
                        ResultWrapper.Status.SUCCESS -> {
                            swipeRefreshLayout.stopRefreshing()
                            result.data?.let { list ->
                                adapter.setDataSource(list)
                            } ?: run {
                                Toast.makeText(
                                    requireContext(),
                                    "No artists data available!",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                    }
                })
            }
        }.onFailure {
            binding.swipeRefreshLayout.isRefreshing = false
            it.printStackTrace()
        }
    }

    /**
     * Update popular artists list
     */
    private fun updateArtists() {
        runCatching {
            binding.apply {
                artistViewModel.updateArtists().observe(viewLifecycleOwner, { result ->
                    when (result.status) {
                        ResultWrapper.Status.LOADING -> {
                            swipeRefreshLayout.startRefreshing()
                        }
                        ResultWrapper.Status.ERROR -> {
                            swipeRefreshLayout.stopRefreshing()
                            Toast.makeText(requireContext(), result.message, Toast.LENGTH_LONG)
                                .show()
                        }
                        ResultWrapper.Status.SUCCESS -> {
                            swipeRefreshLayout.stopRefreshing()
                            result.data?.let { list ->
                                adapter.setDataSource(list)
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