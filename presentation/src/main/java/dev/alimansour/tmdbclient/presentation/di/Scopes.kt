package dev.alimansour.tmdbclient.presentation.di

import javax.inject.Scope

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
@Scope
@Retention(AnnotationRetention.BINARY)
annotation class ArtistScope

@Scope
@Retention(AnnotationRetention.BINARY)
annotation class MovieScope

@Scope
@Retention(AnnotationRetention.BINARY)
annotation class TVShowScope