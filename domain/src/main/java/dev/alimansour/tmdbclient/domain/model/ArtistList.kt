package dev.alimansour.tmdbclient.domain.model

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
data class ArtistList(val artists: List<Artist>) {
    data class Artist(
        val id: Int,
        val name: String,
        val popularity: Double,
        val profilePath: String
    )
}