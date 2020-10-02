package dev.alimansour.tmdbclient.data.repository.movie.datasourceimpl

import dev.alimansour.tmdbclient.data.api.TMDBService
import dev.alimansour.tmdbclient.data.model.MovieResponse
import dev.alimansour.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieResponse> = tmdbService.getPopularMovies()
}