package dev.alimansour.tmdbclient.domain.usecase.movie

import dev.alimansour.tmdbclient.domain.model.MovieList
import dev.alimansour.tmdbclient.domain.repository.MoviesRepositoryImpl
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class UpdateMoviesUseCaseTest {
    private lateinit var updateMoviesUseCase: UpdateMoviesUseCase

    @Before
    fun setUp() {
        val repository = MoviesRepositoryImpl()
        updateMoviesUseCase = UpdateMoviesUseCase(repository)
    }


    @Test
    fun executeTest() {
        runBlocking {
            // Arrange
            // Act
            val expected = listOf(
                MovieList.Movie(4, "OverView", "poster_path", "21-1-2020", "Fourth Movie", 65.5),
                MovieList.Movie(5, "OverView", "poster_path", "21-2-2020", "Fifth Movie", 25.5),
            )
            // Assert
            assertEquals(expected, updateMoviesUseCase.execute())
        }
    }
}