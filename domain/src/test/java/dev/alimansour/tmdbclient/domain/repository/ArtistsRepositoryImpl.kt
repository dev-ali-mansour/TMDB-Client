package dev.alimansour.tmdbclient.domain.repository

import dev.alimansour.tmdbclient.domain.model.ArtistList

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class ArtistsRepositoryImpl : ArtistsRepository {
    override suspend fun getArtists(): List<ArtistList.Artist>? {
        return listOf(
            ArtistList.Artist(1, "First Artist", 45.5, "profile_path"),
            ArtistList.Artist(2, "Second Artist", 32.5, "profile_path"),
            ArtistList.Artist(3, "Third Artist", 39.0, "profile_path")
        )
    }

    override suspend fun updateArtists(): List<ArtistList.Artist>? {
        return listOf(
            ArtistList.Artist(4, "Fourth Artist", 35.5, "profile_path"),
            ArtistList.Artist(5, "Fifth Artist", 23.0, "profile_path")
        )
    }

}
