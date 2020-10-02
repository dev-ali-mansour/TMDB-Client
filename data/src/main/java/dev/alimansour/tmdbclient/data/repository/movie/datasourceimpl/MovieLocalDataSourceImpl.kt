package dev.alimansour.tmdbclient.data.repository.movie.datasourceimpl

import dev.alimansour.tmdbclient.data.db.dao.MovieDao
import dev.alimansour.tmdbclient.data.db.entity.MovieEntity
import dev.alimansour.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
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
class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDataSource {

    override suspend fun getMoviesFromDB(): List<MovieEntity> = movieDao.getMovies()

    override suspend fun saveMoviesToDB(movies: List<MovieEntity>) {
        runCatching {
            CoroutineScope(Dispatchers.IO).launch {
                movieDao.saveMovies(movies)
            }
        }.onFailure { it.printStackTrace() }
    }

    override suspend fun clearAll() {
        runCatching {
            CoroutineScope(Dispatchers.IO).launch {
                movieDao.deleteAllMovies()
            }
        }.onFailure { it.printStackTrace() }
    }
}