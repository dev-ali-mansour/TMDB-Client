package dev.alimansour.tmdbclient.domain.model

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
data class TvShowList(val tvShows: List<TvShow>) {
    data class TvShow(
        val firstAirDate: String,
        val id: Int,
        val name: String,
        val overview: String,
        val posterPath: String,
        val popularity: Double
    )
}