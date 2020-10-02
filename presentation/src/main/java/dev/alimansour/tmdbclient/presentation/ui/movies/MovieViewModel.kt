package dev.alimansour.tmdbclient.presentation.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dev.alimansour.tmdbclient.domain.usecase.movie.GetMoviesUseCase
import dev.alimansour.tmdbclient.domain.usecase.movie.UpdateMoviesUseCase

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    /**
     * Get list of popular movies
     */
    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    /**
     * Update the list of popular movies
     */
    fun updateMovies() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}