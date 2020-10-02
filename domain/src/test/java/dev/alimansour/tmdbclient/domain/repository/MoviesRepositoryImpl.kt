package dev.alimansour.tmdbclient.domain.repository

import dev.alimansour.tmdbclient.domain.model.MovieList.Movie

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class MoviesRepositoryImpl : MoviesRepository {
    override suspend fun getMovies(): List<Movie>? {
        return listOf(
            Movie(1, "OverView", "poster_path", "21-1-2020", "First Movie", 45.5),
            Movie(2, "OverView", "poster_path", "21-2-2020", "Second Movie", 55.5),
            Movie(3, "OverView", "poster_path", "21-3-2020", "Third Movie", 35.5)
        )
    }

    override suspend fun updateMovies(): List<Movie>? {
        return listOf(
            Movie(4, "OverView", "poster_path", "21-1-2020", "Fourth Movie", 65.5),
            Movie(5, "OverView", "poster_path", "21-2-2020", "Fifth Movie", 25.5),
        )
    }


}
