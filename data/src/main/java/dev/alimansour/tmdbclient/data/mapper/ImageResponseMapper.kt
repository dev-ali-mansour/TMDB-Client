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
class ImageResponseMapper @Inject constructor(private val imageMapper: ImageMapper) :
    Mapper<ImageResponse, ImageList> {
    override fun mapFromEntity(type: ImageResponse): ImageList {
        return ImageList(type.images.map {
            imageMapper.mapFromEntity(it)
        }, type.id)
    }

    override fun mapToEntity(type: ImageList): ImageResponse {
        return ImageResponse(type.images.map {
            imageMapper.mapToEntity(it)
        }, type.id)
    }
}