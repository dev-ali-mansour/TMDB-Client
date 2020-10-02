package dev.alimansour.tmdbclient.data.repository.movie.datasource

import dev.alimansour.tmdbclient.data.model.MovieResponse
import retrofit2.Response

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
interface MovieRemoteDataSource {
    /**
     * Get popular movies from API
     * @return Response object of MovieResponse
     */
    suspend fun getMovies(): Response<MovieResponse>
}