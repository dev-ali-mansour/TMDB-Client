package dev.alimansour.tmdbclient.presentation.ui.tvshows

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dev.alimansour.tmdbclient.databinding.FragmentTvShowsBinding
import dev.alimansour.tmdbclient.domain.util.ResultWrapper
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
class TVShowsFragment : Fragment() {
    private lateinit var binding: FragmentTvShowsBinding
    private lateinit var tvShowViewModel: TVShowViewModel

    @Inject
    lateinit var factory: TVShowViewModelFactory

    @Inject
    lateinit var adapter: TVShowAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        runCatching {
            // Inject fragment to MainComponent
            (requireActivity().application as Injector).createTvShowSubComponent()
                .inject(this)
        }.onFailure { it.printStackTrace() }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        runCatching {
            binding = FragmentTvShowsBinding.inflate(layoutInflater, container, false)
            tvShowViewModel = ViewModelProvider(this, factory).get(TVShowViewModel::class.java)

            binding.swipeRefreshLayout.setOnRefreshListener {
                binding.swipeRefreshLayout.stopRefreshing()
                updateTVShows()
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
                tvShowAdapter = adapter
                displayPopularTVShows()
            }
        }.onFailure { it.printStackTrace() }
    }

    /**
     * Display popular TV shows
     */
    private fun displayPopularTVShows() {
        runCatching {
            binding.apply {
                tvShowViewModel.getTVShows().observe(viewLifecycleOwner, { result ->
                    when (result.status) {
                        ResultWrapper.Status.LOADING -> {
                            swipeRefreshLayout.post {
                                swipeRefreshLayout.isRefreshing = true
                            }
                        }
                        ResultWrapper.Status.ERROR -> {
                            swipeRefreshLayout.stopRefreshing()
                            Toast.makeText(requireContext(), result.message, Toast.LENGTH_LONG)
                                .show()
                        }
                        ResultWrapper.Status.SUCCESS -> {
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
     * Update popular TVShow list
     */
    private fun updateTVShows() {
        runCatching {
            binding.apply {
                tvShowViewModel.updateTVShows().observe(viewLifecycleOwner, { result ->
                    when (result.status) {
                        ResultWrapper.Status.LOADING -> {
                            swipeRefreshLayout.post {
                                swipeRefreshLayout.isRefreshing = true
                            }
                        }
                        ResultWrapper.Status.ERROR -> {
                            swipeRefreshLayout.stopRefreshing()
                            Toast.makeText(requireContext(), result.message, Toast.LENGTH_LONG)
                                .show()
                        }
                        ResultWrapper.Status.SUCCESS -> {
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