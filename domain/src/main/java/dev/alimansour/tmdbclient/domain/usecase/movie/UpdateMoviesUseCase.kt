package dev.alimansour.tmdbclient.domain.usecase.movie

import dev.alimansour.tmdbclient.domain.repository.MoviesRepository

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class UpdateMoviesUseCase(private val repository: MoviesRepository) {
    suspend fun execute() = repository.updateMovies()
}