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
class GetMoviesUseCaseTest {
    private lateinit var getMoviesUseCase: GetMoviesUseCase

    @Before
    fun setUp() {
        val repository = MoviesRepositoryImpl()
        getMoviesUseCase = GetMoviesUseCase(repository)
    }


    @Test
    fun executeTest() {
        runBlocking {
            // Arrange
            // Act
            val expected = listOf(
                MovieList.Movie(1, "OverView", "poster_path", "21-1-2020", "First Movie", 45.5),
                MovieList.Movie(2, "OverView", "poster_path", "21-2-2020", "Second Movie", 55.5),
                MovieList.Movie(3, "OverView", "poster_path", "21-3-2020", "Third Movie", 35.5)
            )
            // Assert
            assertEquals(expected, getMoviesUseCase.execute())
        }
    }
}