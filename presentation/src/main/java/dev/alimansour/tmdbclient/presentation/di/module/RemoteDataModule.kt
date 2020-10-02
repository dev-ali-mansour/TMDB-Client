package dev.alimansour.tmdbclient.presentation.di.module

import dagger.Module
import dagger.Provides
import dev.alimansour.tmdbclient.data.api.TMDBService
import dev.alimansour.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import dev.alimansour.tmdbclient.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import dev.alimansour.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import dev.alimansour.tmdbclient.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import dev.alimansour.tmdbclient.data.repository.tvshow.datasource.TVShowRemoteDataSource
import dev.alimansour.tmdbclient.data.repository.tvshow.datasourceimpl.TVShowRemoteDataSourceImpl
import javax.inject.Singleton

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
@Module
object RemoteDataModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService)
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: TMDBService): TVShowRemoteDataSource {
        return TVShowRemoteDataSourceImpl(tmdbService)
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService)
    }
}