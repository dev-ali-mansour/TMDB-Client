package dev.alimansour.tmdbclient.domain.repository

import dev.alimansour.tmdbclient.domain.model.TvShowList.TvShow

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
interface TVShowsRepository {

    /**
     * Get list of most popular TV shows
     * @return List of TV shows
     */
    suspend fun getTVShows(): List<TvShow>?

    /**
     * Update the list of most popular TV shows with the most recent list
     * @return List of TV shows
     */
    suspend fun updateTVShows(): List<TvShow>?
}