package dev.alimansour.tmdbclient.data.repository.movie.datasourceimpl

import dev.alimansour.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import dev.alimansour.tmdbclient.domain.model.MovieList.Movie

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private var moviesList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> = moviesList

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        moviesList.clear()
        moviesList = ArrayList(movies)
    }
}