package dev.alimansour.tmdbclient.data.repository.movie.datasource

import dev.alimansour.tmdbclient.data.db.entity.MovieEntity

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
interface MovieLocalDataSource {

    /**
     * Retrieve list of popular movies from the local database
     * @return list of movies
     */
    suspend fun getMoviesFromDB(): List<MovieEntity>

    /**
     * Save list of popular movies to the local database
     * @param movies List of movies
     */
    suspend fun saveMoviesToDB(movies: List<MovieEntity>)

    /**
     * Clear all movies from the local database
     */
    suspend fun clearAll()
}