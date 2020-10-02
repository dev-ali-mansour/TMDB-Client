package dev.alimansour.tmdbclient.data.api

import dev.alimansour.tmdbclient.data.model.ArtistResponse
import dev.alimansour.tmdbclient.data.model.MovieResponse
import dev.alimansour.tmdbclient.data.model.TVShowResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(): Response<MovieResponse>

    @GET("tv/popular")
    suspend fun getPopularTvShows(): Response<TVShowResponse>

    @GET("person/popular")
    suspend fun getPopularArtists(): Response<ArtistResponse>
}