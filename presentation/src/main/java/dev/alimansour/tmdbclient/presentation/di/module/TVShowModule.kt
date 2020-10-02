package dev.alimansour.tmdbclient.presentation.di.module

import dagger.Module
import dagger.Provides
import dev.alimansour.tmdbclient.domain.usecase.movie.GetMoviesUseCase
import dev.alimansour.tmdbclient.domain.usecase.movie.UpdateMoviesUseCase
import dev.alimansour.tmdbclient.presentation.di.MovieScope
import dev.alimansour.tmdbclient.presentation.ui.movies.MovieViewModelFactory

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
@Module
object TVShowModule {

    @JvmStatic
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase
        )
    }
}