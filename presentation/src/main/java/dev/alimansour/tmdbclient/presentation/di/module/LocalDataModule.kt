package dev.alimansour.tmdbclient.presentation.di.module

import dagger.Module
import dagger.Provides
import dev.alimansour.tmdbclient.data.db.dao.ArtistDao
import dev.alimansour.tmdbclient.data.db.dao.MovieDao
import dev.alimansour.tmdbclient.data.db.dao.TVShowDao
import dev.alimansour.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import dev.alimansour.tmdbclient.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import dev.alimansour.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import dev.alimansour.tmdbclient.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import dev.alimansour.tmdbclient.data.repository.tvshow.datasource.TVShowLocalDataSource
import dev.alimansour.tmdbclient.data.repository.tvshow.datasourceimpl.TVShowLocalDataSourceImpl
import javax.inject.Singleton

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
@Module
object LocalDataModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TVShowDao): TVShowLocalDataSource {
        return TVShowLocalDataSourceImpl(tvShowDao)
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}