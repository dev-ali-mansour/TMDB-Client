package dev.alimansour.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.alimansour.tmdbclient.data.db.dao.ArtistDao
import dev.alimansour.tmdbclient.data.db.dao.MovieDao
import dev.alimansour.tmdbclient.data.db.dao.TVShowDao
import dev.alimansour.tmdbclient.data.db.entity.ArtistEntity
import dev.alimansour.tmdbclient.data.db.entity.MovieEntity
import dev.alimansour.tmdbclient.data.db.entity.TVShowEntity

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
@Database(
    entities = [MovieEntity::class, TVShowEntity::class, ArtistEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TVShowDao
    abstract fun artistDao(): ArtistDao
}