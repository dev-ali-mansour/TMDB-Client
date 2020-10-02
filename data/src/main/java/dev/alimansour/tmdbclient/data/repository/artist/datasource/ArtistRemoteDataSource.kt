package dev.alimansour.tmdbclient.data.repository.artist.datasource

import dev.alimansour.tmdbclient.data.model.ArtistResponse
import retrofit2.Response

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
interface ArtistRemoteDataSource {
    /**
     * Get popular artists from API
     * @return Response object of ArtistResponse
     */
    suspend fun getArtists(): Response<ArtistResponse>
}