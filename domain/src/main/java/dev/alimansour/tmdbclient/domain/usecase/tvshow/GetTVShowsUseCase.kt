package dev.alimansour.tmdbclient.domain.usecase.tvshow

import dev.alimansour.tmdbclient.domain.repository.TVShowsRepository
import javax.inject.Inject

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class GetTVShowsUseCase @Inject constructor(private val repository: TVShowsRepository) {
    suspend fun execute() = repository.getTVShows()
}