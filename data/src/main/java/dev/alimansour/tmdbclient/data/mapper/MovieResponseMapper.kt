package dev.alimansour.tmdbclient.data.mapper

import dev.alimansour.tmdbclient.data.model.MovieResponse
import dev.alimansour.tmdbclient.domain.model.MovieList
import javax.inject.Inject

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class MovieResponseMapper @Inject constructor(private val movieMapper: MovieMapper) :
    Mapper<MovieResponse, MovieList> {
    override fun mapFromEntity(type: MovieResponse): MovieList {
        return MovieList(type.movies.map {
            movieMapper.mapFromEntity(it)
        })
    }

    override fun mapToEntity(type: MovieList): MovieResponse {
        return MovieResponse(type.movies.map {
            movieMapper.mapToEntity(it)
        })
    }
}