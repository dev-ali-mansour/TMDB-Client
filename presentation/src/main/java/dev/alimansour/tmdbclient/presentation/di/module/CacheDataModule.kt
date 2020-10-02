package dev.alimansour.tmdbclient.presentation.di.module

import dagger.Module
import dagger.Provides
import dev.alimansour.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import dev.alimansour.tmdbclient.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import dev.alimansour.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import dev.alimansour.tmdbclient.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import dev.alimansour.tmdbclient.data.repository.tvshow.datasource.TVShowCacheDataSource
import dev.alimansour.tmdbclient.data.repository.tvshow.datasourceimpl.TVShowCacheDataSourceImpl
import javax.inject.Singleton

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
@Module
object CacheDataModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TVShowCacheDataSource {
        return TVShowCacheDataSourceImpl()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}