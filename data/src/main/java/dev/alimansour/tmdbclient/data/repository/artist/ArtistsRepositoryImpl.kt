package dev.alimansour.tmdbclient.data.repository.artist

import dev.alimansour.tmdbclient.data.mapper.ArtistMapper
import dev.alimansour.tmdbclient.data.mapper.ArtistResponseMapper
import dev.alimansour.tmdbclient.data.mapper.ImageResponseMapper
import dev.alimansour.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import dev.alimansour.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import dev.alimansour.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import dev.alimansour.tmdbclient.domain.model.ArtistList.Artist
import dev.alimansour.tmdbclient.domain.model.ImageList
import dev.alimansour.tmdbclient.domain.repository.ArtistsRepository

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class ArtistsRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource,
    private val artistResponseMapper: ArtistResponseMapper,
    private val artistMapper: ArtistMapper,
    private val imageResponseMapper: ImageResponseMapper
) : ArtistsRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newArtistList = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newArtistList.map {
            artistMapper.mapToEntity(it)
        })
        artistCacheDataSource.saveArtistsToCache(newArtistList)
        return newArtistList
    }

    override suspend fun getImages(userId: Int): List<ImageList.Image>? = getImagesFromAPI(userId)

    /**
     * Get list of popular artists from TMDB API
     * @return List of Artist objects
     */
    private suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>
        runCatching {
            val response = artistRemoteDataSource.getArtists()
            if (response.isSuccessful) {
                response.body()?.let {
                    artistList = artistResponseMapper.mapFromEntity(it).artists
                }
            }
        }.onFailure { it.printStackTrace() }
        return artistList
    }

    /**
     * Get list of popular artists from the local database
     * @return List of Artist objects
     */
    private suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        runCatching {
            artistList = artistLocalDataSource.getArtistsFromDB().map {
                artistMapper.mapFromEntity(it)
            }
            if (artistList.isNotEmpty()) {
                return artistList
            } else {
                artistList = getArtistsFromAPI()
                artistLocalDataSource.saveArtistsToDB(artistList.map {
                    artistMapper.mapToEntity(it)
                })
            }
        }.onFailure { it.printStackTrace() }

        return artistList
    }

    /**
     * Get list of popular artists from the device cache
     * @return List of Artist objects
     */
    private suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>
        runCatching {
            artistList = artistCacheDataSource.getArtistsFromCache()
        }.onFailure { it.printStackTrace() }
        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList
    }

    private suspend fun getImagesFromAPI(userId: Int): List<ImageList.Image> {
        lateinit var imageList: List<ImageList.Image>
        runCatching {
            val response = artistRemoteDataSource.getImages(userId)
            if (response.isSuccessful) {
                response.body()?.let {
                    imageList = imageResponseMapper.mapFromEntity(it).images
                }
            }
        }.onFailure { it.printStackTrace() }
        return imageList
    }
}