package dev.alimansour.tmdbclient.presentation.di.component

import dagger.Subcomponent
import dev.alimansour.tmdbclient.presentation.di.ArtistScope
import dev.alimansour.tmdbclient.presentation.di.module.ArtistModule
import dev.alimansour.tmdbclient.presentation.ui.artists.ArtistsFragment

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): ArtistSubComponent
    }

    fun inject(artistsFragment: ArtistsFragment)
}