package dev.alimansour.tmdbclient.domain.repository

import dev.alimansour.tmdbclient.domain.model.artist.Artist

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
interface ArtistsRepository {

    /**
     * Get list of most popular artists
     * @return List of artists
     */
    suspend fun getArtists(): List<Artist>?

    /**
     * Update the list of most popular artists with the most recent list
     * @return List of artists
     */
    suspend fun updateArtists(): List<Artist>?
}