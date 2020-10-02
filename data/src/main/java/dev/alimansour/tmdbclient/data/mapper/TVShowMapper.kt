package dev.alimansour.tmdbclient.data.mapper

import dev.alimansour.tmdbclient.data.db.entity.TVShowEntity
import dev.alimansour.tmdbclient.domain.model.TvShowList.TvShow
import javax.inject.Inject

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class TVShowMapper @Inject constructor() : Mapper<TVShowEntity, TvShow> {
    override fun mapFromEntity(type: TVShowEntity): TvShow {
        return TvShow(
            type.firstAirDate,
            type.id,
            type.name,
            type.overview,
            type.posterPath,
            type.popularity
        )
    }

    override fun mapToEntity(type: TvShow): TVShowEntity {
        return TVShowEntity(
            type.firstAirDate,
            type.id,
            type.name,
            type.overview,
            type.posterPath,
            type.popularity
        )
    }
}