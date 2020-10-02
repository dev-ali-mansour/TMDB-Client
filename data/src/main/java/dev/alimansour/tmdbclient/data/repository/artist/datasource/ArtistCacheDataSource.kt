package dev.alimansour.tmdbclient.data.repository.artist.datasource

import dev.alimansour.tmdbclient.domain.model.ArtistList.Artist


/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
interface ArtistCacheDataSource {

    /**
     * Retrieve list of popular artists from device cache
     * @return list of artists
     */
    suspend fun getArtistsFromCache(): List<Artist>

    /**
     * Save list of popular artists to device cache
     * @param artists List of artists
     */
    suspend fun saveArtistsToCache(artists: List<Artist>)
}