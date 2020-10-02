package dev.alimansour.tmdbclient.presentation.ui.artists

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import dev.alimansour.tmdbclient.databinding.FragmentImagesBinding
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
class ImagesFragment : Fragment() {
    private lateinit var binding: FragmentImagesBinding
    private lateinit var artistViewModel: ArtistViewModel
    private val args: ImagesFragmentArgs by navArgs()
    private var artistId: Int = -1

    @Inject
    lateinit var factory: ArtistViewModelFactory

    @Inject
    lateinit var adapter: ImageAdapter

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
            binding = FragmentImagesBinding.inflate(layoutInflater, container, false)
            artistViewModel = ViewModelProvider(this, factory).get(ArtistViewModel::class.java)
        }.onFailure { it.printStackTrace() }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        runCatching {
            artistId = args.userId

            initRecyclerView()
        }.onFailure { it.printStackTrace() }
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
                imageAdapter = adapter
                if (artistId > 0) displayPopularArtistImages(artistId)
            }
        }.onFailure { it.printStackTrace() }
    }

    /**
     * Display list of images of a popular artist
     * @param userId User Id
     */
    private fun displayPopularArtistImages(userId: Int) {
        runCatching {
            binding.apply {
                artistViewModel.getImages(userId).observe(viewLifecycleOwner, { result ->
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
                            swipeRefreshLayout.isEnabled = false
                            result.data?.let { list ->
                                adapter.setDataSource(list)
                            } ?: run {
                                Toast.makeText(
                                    requireContext(),
                                    "No artist images data available!",
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
}