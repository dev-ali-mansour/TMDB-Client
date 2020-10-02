package dev.alimansour.tmdbclient.data.repository.tvshow.datasource

import dev.alimansour.tmdbclient.data.db.entity.TVShowEntity


/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
interface TVShowLocalDataSource {

    /**
     * Retrieve list of popular TV shows from the local database
     * @return list of TV shows
     */
    suspend fun getTVShowsFromDB(): List<TVShowEntity>

    /**
     * Save list of popular movies to the local database
     * @param tvShowEntities List of TV shows
     */
    suspend fun saveTVShowsToDB(tvShowEntities: List<TVShowEntity>)

    /**
     * Clear all TV shows from the local database
     */
    suspend fun clearAll()
}