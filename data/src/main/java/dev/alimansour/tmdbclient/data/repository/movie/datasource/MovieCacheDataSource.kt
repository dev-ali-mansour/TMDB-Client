package dev.alimansour.tmdbclient.data.repository.movie.datasource

import dev.alimansour.tmdbclient.domain.model.MovieList.Movie

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
interface MovieCacheDataSource {

    /**
     * Retrieve list of popular movies from device cache
     * @return list of movies
     */
    suspend fun getMoviesFromCache(): List<Movie>

    /**
     * Save list of popular movies to device cache
     * @param movies List of movies
     */
    suspend fun saveMoviesToCache(movies: List<Movie>)
}