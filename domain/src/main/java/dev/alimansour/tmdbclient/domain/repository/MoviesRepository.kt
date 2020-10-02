package dev.alimansour.tmdbclient.domain.repository

import dev.alimansour.tmdbclient.domain.model.MovieList.Movie

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
interface MoviesRepository {

    /**
     * Get list of most popular movies
     * @return List of movies
     */
    suspend fun getMovies(): List<Movie>?

    /**
     * Update the list of most popular movies with the most recent list
     * @return List of movies
     */
    suspend fun updateMovies(): List<Movie>?
}