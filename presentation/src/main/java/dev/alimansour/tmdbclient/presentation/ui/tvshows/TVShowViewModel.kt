package dev.alimansour.tmdbclient.presentation.ui.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dev.alimansour.tmdbclient.domain.usecase.tvshow.GetTVShowsUseCase
import dev.alimansour.tmdbclient.domain.usecase.tvshow.UpdateTVShowsUseCase

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class TVShowViewModel(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val updateTVShowsUseCase: UpdateTVShowsUseCase
) : ViewModel() {

    /**
     * Get list of popular TV shows
     */
    fun getTVShows() = liveData {
        val tvShowList = getTVShowsUseCase.execute()
        emit(tvShowList)
    }

    /**
     * Update the list of popular TV shows
     */
    fun updateTVShows() = liveData {
        val tvShowList = updateTVShowsUseCase.execute()
        emit(tvShowList)
    }
}