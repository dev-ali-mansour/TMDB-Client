package dev.alimansour.tmdbclient.data.repository.tvshow

import dev.alimansour.tmdbclient.data.mapper.TVShowMapper
import dev.alimansour.tmdbclient.data.mapper.TVShowResponseMapper
import dev.alimansour.tmdbclient.data.repository.tvshow.datasource.TVShowCacheDataSource
import dev.alimansour.tmdbclient.data.repository.tvshow.datasource.TVShowLocalDataSource
import dev.alimansour.tmdbclient.data.repository.tvshow.datasource.TVShowRemoteDataSource
import dev.alimansour.tmdbclient.domain.model.TvShowList.TvShow
import dev.alimansour.tmdbclient.domain.repository.TVShowsRepository

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class TVShowsRepositoryImpl(
    private val tvShowRemoteDataSource: TVShowRemoteDataSource,
    private val tvShowLocalDataSource: TVShowLocalDataSource,
    private val tvShowCacheDataSource: TVShowCacheDataSource,
    private val tvShowResponseMapper: TVShowResponseMapper,
    private val tvShowMapper: TVShowMapper
) : TVShowsRepository {

    override suspend fun getTVShows(): List<TvShow>? = getTVShowsFromCache()

    override suspend fun updateTVShows(): List<TvShow>? {
        val newTVShowList = getTVShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTVShowsToDB(newTVShowList.map {
            tvShowMapper.mapToEntity(it)
        })
        tvShowCacheDataSource.saveTVShowsToCache(newTVShowList)
        return newTVShowList
    }

    /**
     * Get list of popular TV shows from TMDB API
     * @return List of TvShow objects
     */
    private suspend fun getTVShowsFromAPI(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        runCatching {
            val response = tvShowRemoteDataSource.getTVShows()
            if (response.isSuccessful) {
                response.body()?.let {
                    tvShowList = tvShowResponseMapper.mapFromEntity(it).tvShows
                }
            }
        }.onFailure { it.printStackTrace() }
        return tvShowList
    }

    /**
     * Get list of popular TV shows from the local database
     * @return List of Movie objects
     */
    private suspend fun getMoviesFromDB(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        runCatching {
            tvShowList = tvShowLocalDataSource.getTVShowsFromDB().map {
                tvShowMapper.mapFromEntity(it)
            }
            if (tvShowList.isNotEmpty()) {
                return tvShowList
            } else {
                tvShowList = getTVShowsFromAPI()
                tvShowLocalDataSource.saveTVShowsToDB(tvShowList.map {
                    tvShowMapper.mapToEntity(it)
                })
            }
        }.onFailure { it.printStackTrace() }

        return tvShowList
    }

    /**
     * Get list of popular TV shows from the device cache
     * @return List of TvShow objects
     */
    private suspend fun getTVShowsFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        runCatching {
            tvShowList = tvShowCacheDataSource.getTVShowsFromCache()
        }.onFailure { it.printStackTrace() }
        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getMoviesFromDB()
            tvShowCacheDataSource.saveTVShowsToCache(tvShowList)
        }

        return tvShowList
    }
}