package dev.alimansour.tmdbclient.data.repository.tvshow.datasourceimpl

import dev.alimansour.tmdbclient.data.api.TMDBService
import dev.alimansour.tmdbclient.data.model.TVShowResponse
import dev.alimansour.tmdbclient.data.repository.tvshow.datasource.TVShowRemoteDataSource
import retrofit2.Response

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class TVShowRemoteDataSourceImpl(private val tmdbService: TMDBService) : TVShowRemoteDataSource {
    override suspend fun getTVShows(): Response<TVShowResponse> = tmdbService.getPopularTvShows()
}