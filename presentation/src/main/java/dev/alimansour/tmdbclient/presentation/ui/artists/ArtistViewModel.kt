package dev.alimansour.tmdbclient.presentation.ui.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dev.alimansour.tmdbclient.domain.usecase.artist.GetArtistImagesUseCase
import dev.alimansour.tmdbclient.domain.usecase.artist.GetArtistsUseCase
import dev.alimansour.tmdbclient.domain.usecase.artist.UpdateArtistsUseCase
import dev.alimansour.tmdbclient.domain.util.ResultWrapper

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase,
    private val getArtistImagesUseCase: GetArtistImagesUseCase
) : ViewModel() {

    /**
     * Get list of popular artists
     */
    fun getArtists() = liveData {
        runCatching {
            emit(ResultWrapper.loading(null))
            emit(
                ResultWrapper.success(
                    getArtistsUseCase.execute()?.sortedByDescending { it.popularity })
            )
        }
    }

    /**
     * Update the list of popular artists
     */
    fun updateArtists() = liveData {
        runCatching {
            emit(ResultWrapper.loading(null))
            emit(
                ResultWrapper.success(
                    updateArtistsUseCase.execute()?.sortedByDescending { it.popularity })
            )
        }.onFailure {
            it.message?.let { message -> emit(ResultWrapper.error(null, message)) }
        }
    }

    /**
     * Get image list for popular artist
     * @param userId User Id
     */
    fun getImages(userId: Int) = liveData {
        runCatching {
            emit(ResultWrapper.loading(null))
            emit(
                ResultWrapper.success(
                    getArtistImagesUseCase.execute(userId)?.sortedByDescending { it.voteAverage })
            )
        }.onFailure {
            it.message?.let { message -> emit(ResultWrapper.error(null, message)) }
        }
    }
}