package dev.alimansour.tmdbclient.data.mapper

import dev.alimansour.tmdbclient.data.model.ArtistResponse
import dev.alimansour.tmdbclient.domain.model.ArtistList
import javax.inject.Inject

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class ArtistResponseMapper @Inject constructor(private val artistMapper: ArtistMapper) :
    Mapper<ArtistResponse, ArtistList> {
    override fun mapFromEntity(type: ArtistResponse): ArtistList {
        return ArtistList(type.artists.map {
            artistMapper.mapFromEntity(it)
        })
    }

    override fun mapToEntity(type: ArtistList): ArtistResponse {
        return ArtistResponse(type.artists.map {
            artistMapper.mapToEntity(it)
        })
    }
}