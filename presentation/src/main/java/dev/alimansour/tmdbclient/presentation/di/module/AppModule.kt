package dev.alimansour.tmdbclient.presentation.di.module

import dagger.Module
import dagger.Provides
import dev.alimansour.tmdbclient.data.mapper.*
import dev.alimansour.tmdbclient.data.repository.artist.ArtistsRepositoryImpl
import dev.alimansour.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import dev.alimansour.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import dev.alimansour.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import dev.alimansour.tmdbclient.data.repository.movie.MoviesRepositoryImpl
import dev.alimansour.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import dev.alimansour.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import dev.alimansour.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import dev.alimansour.tmdbclient.data.repository.tvshow.TVShowsRepositoryImpl
import dev.alimansour.tmdbclient.data.repository.tvshow.datasource.TVShowCacheDataSource
import dev.alimansour.tmdbclient.data.repository.tvshow.datasource.TVShowLocalDataSource
import dev.alimansour.tmdbclient.data.repository.tvshow.datasource.TVShowRemoteDataSource
import dev.alimansour.tmdbclient.domain.repository.ArtistsRepository
import dev.alimansour.tmdbclient.domain.repository.MoviesRepository
import dev.alimansour.tmdbclient.domain.repository.TVShowsRepository
import javax.inject.Singleton

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
@Module()
object AppModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideArtistsRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource,
        artistResponseMapper: ArtistResponseMapper,
        artistMapper: ArtistMapper
    ): ArtistsRepository {
        return ArtistsRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource,
            artistResponseMapper,
            artistMapper
        )
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideMoviesRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource,
        movieResponseMapper: MovieResponseMapper,
        movieMapper: MovieMapper
    ): MoviesRepository {
        return MoviesRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource,
            movieResponseMapper,
            movieMapper
        )
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideTVShowsRepository(
        tvShowRemoteDataSource: TVShowRemoteDataSource,
        tvShowLocalDataSource: TVShowLocalDataSource,
        tvShowCacheDataSource: TVShowCacheDataSource,
        tvShowResponseMapper: TVShowResponseMapper,
        tvShowMapper: TVShowMapper
    ): TVShowsRepository {
        return TVShowsRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource,
            tvShowResponseMapper,
            tvShowMapper
        )
    }
}