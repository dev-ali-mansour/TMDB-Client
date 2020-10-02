package dev.alimansour.tmdbclient.data.mapper

import dev.alimansour.tmdbclient.data.model.ImageResponse
import dev.alimansour.tmdbclient.domain.model.ImageList
import javax.inject.Inject

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class ImageMapper @Inject constructor() : Mapper<ImageResponse.Image, ImageList.Image> {
    override fun mapFromEntity(type: ImageResponse.Image): ImageList.Image {
        return ImageList.Image(
            type.width,
            type.height,
            type.voteCount,
            type.voteAverage,
            type.filePath,
            type.aspectRatio
        )
    }

    override fun mapToEntity(type: ImageList.Image): ImageResponse.Image {
        return ImageResponse.Image(
            type.width,
            type.height,
            type.voteCount,
            type.voteAverage,
            type.filePath,
            type.aspectRatio
        )
    }
}