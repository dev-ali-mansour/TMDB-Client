package dev.alimansour.tmdbclient.presentation.di.module

import dagger.Module
import dagger.Provides
import dev.alimansour.tmdbclient.domain.usecase.tvshow.GetTVShowsUseCase
import dev.alimansour.tmdbclient.domain.usecase.tvshow.UpdateTVShowsUseCase
import dev.alimansour.tmdbclient.presentation.di.TVShowScope
import dev.alimansour.tmdbclient.presentation.ui.tvshows.TVShowViewModelFactory

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
@Module
object MovieModule {

    @JvmStatic
    @TVShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTVShowsUseCase,
        updateTvShowsUseCase: UpdateTVShowsUseCase
    ): TVShowViewModelFactory {
        return TVShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }
}