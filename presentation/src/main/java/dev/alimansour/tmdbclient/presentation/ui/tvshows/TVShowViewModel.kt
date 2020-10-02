package dev.alimansour.tmdbclient.presentation.ui.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dev.alimansour.tmdbclient.domain.usecase.tvshow.GetTVShowsUseCase
import dev.alimansour.tmdbclient.domain.usecase.tvshow.UpdateTVShowsUseCase
import dev.alimansour.tmdbclient.domain.util.ResultWrapper

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
        runCatching {
            emit(ResultWrapper.loading(null))
            emit(
                ResultWrapper.success(
                    getTVShowsUseCase.execute()?.sortedByDescending { it.popularity })
            )
        }.onFailure {
            it.message?.let { message -> emit(ResultWrapper.error(null, message)) }
        }
    }

    /**
     * Update the list of popular TV shows
     */
    fun updateTVShows() = liveData {
        runCatching {
            emit(ResultWrapper.loading(null))
            emit(
                ResultWrapper.success(
                    updateTVShowsUseCase.execute()?.sortedByDescending { it.popularity })
            )
        }.onFailure {
            it.message?.let { message -> emit(ResultWrapper.error(null, message)) }
        }
    }
}