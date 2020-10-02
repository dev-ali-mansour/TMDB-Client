package dev.alimansour.tmdbclient.data.mapper

import dev.alimansour.tmdbclient.data.db.entity.ArtistEntity
import dev.alimansour.tmdbclient.domain.model.ArtistList.Artist
import javax.inject.Inject

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class ArtistMapper @Inject constructor() : Mapper<ArtistEntity, Artist> {
    override fun mapFromEntity(type: ArtistEntity): Artist {
        return Artist(
            type.id,
            type.name,
            type.popularity,
            type.profilePath
        )
    }

    override fun mapToEntity(type: Artist): ArtistEntity {
        return ArtistEntity(
            type.id,
            type.name,
            type.popularity,
            type.profilePath
        )
    }
}