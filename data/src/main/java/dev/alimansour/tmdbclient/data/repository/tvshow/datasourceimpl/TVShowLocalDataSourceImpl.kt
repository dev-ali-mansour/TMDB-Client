package dev.alimansour.tmdbclient.data.repository.tvshow.datasourceimpl

import dev.alimansour.tmdbclient.data.db.dao.TVShowDao
import dev.alimansour.tmdbclient.data.db.entity.TVShowEntity
import dev.alimansour.tmdbclient.data.repository.tvshow.datasource.TVShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class TVShowLocalDataSourceImpl(private val TVShowDao: TVShowDao) : TVShowLocalDataSource {
    override suspend fun getTVShowsFromDB(): List<TVShowEntity> = TVShowDao.getTvShows()

    override suspend fun saveTVShowsToDB(tvShowEntities: List<TVShowEntity>) {
        runCatching {
            CoroutineScope(Dispatchers.IO).launch {
                TVShowDao.saveTvShows(tvShowEntities)
            }
        }.onFailure { it.printStackTrace() }
    }

    override suspend fun clearAll() {
        runCatching {
            CoroutineScope(Dispatchers.IO).launch {
                TVShowDao.deleteAllTvShows()
            }
        }.onFailure { it.printStackTrace() }
    }
}