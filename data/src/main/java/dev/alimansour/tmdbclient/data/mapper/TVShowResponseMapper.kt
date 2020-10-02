package dev.alimansour.tmdbclient.data.mapper

import dev.alimansour.tmdbclient.data.model.TVShowResponse
import dev.alimansour.tmdbclient.domain.model.TvShowList
import javax.inject.Inject

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class TVShowResponseMapper @Inject constructor(private val tvShowMapper: TVShowMapper) :
    Mapper<TVShowResponse, TvShowList> {
    override fun mapFromEntity(type: TVShowResponse): TvShowList {
        return TvShowList(type.tvShows.map {
            tvShowMapper.mapFromEntity(it)
        })
    }

    override fun mapToEntity(type: TvShowList): TVShowResponse {
        return TVShowResponse(type.tvShows.map {
            tvShowMapper.mapToEntity(it)
        })
    }
}