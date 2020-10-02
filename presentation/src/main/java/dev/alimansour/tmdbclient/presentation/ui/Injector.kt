package dev.alimansour.tmdbclient.presentation.ui

import dev.alimansour.tmdbclient.presentation.di.component.ArtistSubComponent
import dev.alimansour.tmdbclient.presentation.di.component.MovieSubComponent
import dev.alimansour.tmdbclient.presentation.di.component.TVShowSubComponent

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TVShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}