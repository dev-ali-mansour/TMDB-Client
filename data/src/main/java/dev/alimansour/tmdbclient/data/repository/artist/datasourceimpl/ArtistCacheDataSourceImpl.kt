package dev.alimansour.tmdbclient.data.repository.artist.datasourceimpl

import dev.alimansour.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import dev.alimansour.tmdbclient.domain.model.ArtistList.Artist

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class ArtistCacheDataSourceImpl : ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> = artistList

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}