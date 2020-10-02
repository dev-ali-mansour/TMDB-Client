package dev.alimansour.tmdbclient.data.model


import com.google.gson.annotations.SerializedName
import dev.alimansour.tmdbclient.data.db.entity.MovieEntity

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
data class MovieResponse(@SerializedName("results") val movies: List<MovieEntity>)