package dev.alimansour.tmdbclient.data.repository.artist.datasourceimpl

import dev.alimansour.tmdbclient.data.db.dao.ArtistDao
import dev.alimansour.tmdbclient.data.db.entity.ArtistEntity
import dev.alimansour.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
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
class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao) : ArtistLocalDataSource {
    override suspend fun getArtistsFromDB(): List<ArtistEntity> = artistDao.getArtists()

    override suspend fun saveArtistsToDB(artists: List<ArtistEntity>) {
        runCatching {
            CoroutineScope(Dispatchers.IO).launch {
                artistDao.saveArtists(artists)
            }
        }.onFailure { it.printStackTrace() }
    }

    override suspend fun clearAll() {
        runCatching {
            CoroutineScope(Dispatchers.IO).launch {
                artistDao.deleteAllArtists()
            }
        }.onFailure { it.printStackTrace() }
    }
}