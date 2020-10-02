package dev.alimansour.tmdbclient.presentation.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dev.alimansour.tmdbclient.data.db.AppDatabase
import dev.alimansour.tmdbclient.data.db.dao.ArtistDao
import dev.alimansour.tmdbclient.data.db.dao.MovieDao
import dev.alimansour.tmdbclient.data.db.dao.TVShowDao
import dev.alimansour.tmdbclient.presentation.di.AppContext
import javax.inject.Singleton

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
@Module
object RoomModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideAppDatabase(@AppContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "TMDB"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideMovieDao(db: AppDatabase): MovieDao {
        return db.movieDao()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideTvShowDao(db: AppDatabase): TVShowDao {
        return db.tvShowDao()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideArtistDao(db: AppDatabase): ArtistDao {
        return db.artistDao()
    }
}