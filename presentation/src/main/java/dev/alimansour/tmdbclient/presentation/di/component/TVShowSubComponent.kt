package dev.alimansour.tmdbclient.presentation.di.component

import dagger.Subcomponent
import dev.alimansour.tmdbclient.presentation.di.ArtistScope
import dev.alimansour.tmdbclient.presentation.di.module.TVShowModule
import dev.alimansour.tmdbclient.presentation.ui.tvshows.TVShowsFragment

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
@ArtistScope
@Subcomponent(modules = [TVShowModule::class])
interface TVShowSubComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): TVShowSubComponent
    }

    fun inject(tvShowsFragment: TVShowsFragment)
}