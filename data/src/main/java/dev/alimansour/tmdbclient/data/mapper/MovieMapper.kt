package dev.alimansour.tmdbclient.data.mapper

import dev.alimansour.tmdbclient.data.db.entity.MovieEntity
import dev.alimansour.tmdbclient.domain.model.MovieList.Movie
import javax.inject.Inject

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class MovieMapper @Inject constructor() : Mapper<MovieEntity, Movie> {
    override fun mapFromEntity(type: MovieEntity): Movie {
        return Movie(type.id, type.overview, type.posterPath, type.releaseDate, type.title)
    }

    override fun mapToEntity(type: Movie): MovieEntity {
        return MovieEntity(type.id, type.overview, type.posterPath, type.releaseDate, type.title)
    }
}