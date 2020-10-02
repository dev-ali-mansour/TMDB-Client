package dev.alimansour.tmdbclient.domain.repository

import dev.alimansour.tmdbclient.domain.model.TvShowList.TvShow

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class TVShowsRepositoryImpl : TVShowsRepository {
    override suspend fun getTVShows(): List<TvShow>? {
        return listOf(
            TvShow("01-1-2020", 1, "First Show", "Overview", "poster_path", 73.5),
            TvShow("01-2-2020", 2, "Second Show", "Overview", "poster_path", 53.5),
            TvShow("01-3-2020", 3, "Third Show", "Overview", "poster_path", 65.5),
        )
    }

    override suspend fun updateTVShows(): List<TvShow>? {
        return listOf(
            TvShow("01-4-2020", 4, "Fourth Show", "Overview", "poster_path", 75.5),
            TvShow("01-5-2020", 5, "Fifth Show", "Overview", "poster_path", 23.5)
        )
    }
}
