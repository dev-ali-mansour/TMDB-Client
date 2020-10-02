package dev.alimansour.tmdbclient.presentation.ui.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dev.alimansour.tmdbclient.domain.usecase.artist.GetArtistsUseCase
import dev.alimansour.tmdbclient.domain.usecase.artist.UpdateArtistsUseCase

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel() {

    /**
     * Get list of popular artists
     */
    fun getArtists() = liveData {
        val artistList = getArtistsUseCase.execute()
        emit(artistList)
    }

    /**
     * Update the list of popular artists
     */
    fun updateArtists() = liveData {
        val artistList = updateArtistsUseCase.execute()
        emit(artistList)
    }
}