package dev.alimansour.tmdbclient.data.repository.tvshow.datasource

import dev.alimansour.tmdbclient.domain.model.TvShowList.TvShow


/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
interface TVShowCacheDataSource {

    /**
     * Retrieve list of popular TV shows from device cache
     * @return list of TV shows
     */
    suspend fun getTVShowsFromCache(): List<TvShow>

    /**
     * Save list of popular TV shows to device cache
     * @param tvShowEntities List of TV shows
     */
    suspend fun saveTVShowsToCache(tvShowEntities: List<TvShow>)
}