package dev.alimansour.tmdbclient.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
@Entity(tableName = "popular_tvShows")
data class TVShowEntity(
    @SerializedName("first_air_date")
    val firstAirDate: String,
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String
)