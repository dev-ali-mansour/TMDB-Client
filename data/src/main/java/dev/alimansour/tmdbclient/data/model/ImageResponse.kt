package dev.alimansour.tmdbclient.data.model

import com.google.gson.annotations.SerializedName

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
data class ImageResponse(
    @SerializedName("profiles")
    var images: List<Image>,
    @SerializedName("id")
    var id: Int
) {
    data class Image(
        @SerializedName("width")
        var width: Int,
        @SerializedName("height")
        var height: Int,
        @SerializedName("vote_count")
        var voteCount: Int,
        @SerializedName("vote_average")
        var voteAverage: Double,
        @SerializedName("file_path")
        var filePath: String,
        @SerializedName("aspect_ratio")
        var aspectRatio: Double
    )
}