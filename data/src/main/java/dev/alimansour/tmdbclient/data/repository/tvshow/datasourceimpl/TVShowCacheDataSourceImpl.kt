package dev.alimansour.tmdbclient.data.repository.tvshow.datasourceimpl

import dev.alimansour.tmdbclient.data.repository.tvshow.datasource.TVShowCacheDataSource
import dev.alimansour.tmdbclient.domain.model.TvShowList.TvShow

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class TVShowCacheDataSourceImpl : TVShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTVShowsFromCache(): List<TvShow> = tvShowList

    override suspend fun saveTVShowsToCache(tvShowEntities: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShowEntities)
    }
}