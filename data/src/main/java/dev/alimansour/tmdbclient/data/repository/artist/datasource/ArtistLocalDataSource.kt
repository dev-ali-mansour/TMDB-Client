package dev.alimansour.tmdbclient.data.repository.artist.datasource

import dev.alimansour.tmdbclient.data.db.entity.ArtistEntity

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
interface ArtistLocalDataSource {

    /**
     * Retrieve list of popular artists from the local database
     * @return list of artists
     */
    suspend fun getArtistsFromDB(): List<ArtistEntity>

    /**
     * Save list of popular artists to the local database
     * @param artists List of artists
     */
    suspend fun saveArtistsToDB(artists: List<ArtistEntity>)

    /**
     * Clear all artists from the local database
     */
    suspend fun clearAll()
}