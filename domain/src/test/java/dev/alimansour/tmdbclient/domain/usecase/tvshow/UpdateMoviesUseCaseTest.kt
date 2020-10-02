package dev.alimansour.tmdbclient.domain.usecase.tvshow

import dev.alimansour.tmdbclient.domain.model.TvShowList
import dev.alimansour.tmdbclient.domain.repository.TVShowsRepositoryImpl
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
    private lateinit var updateTVShowsUseCase: UpdateTVShowsUseCase

    @Before
    fun setUp() {
        val repository = TVShowsRepositoryImpl()
        updateTVShowsUseCase = UpdateTVShowsUseCase(repository)
    }


    @Test
    fun executeTest() {
        runBlocking {
            // Arrange
            // Act
            val expected = listOf(
                TvShowList.TvShow("01-4-2020", 4, "Fourth Show", "Overview", "poster_path", 75.5),
                TvShowList.TvShow("01-5-2020", 5, "Fifth Show", "Overview", "poster_path", 23.5)
            )
            // Assert
            assertEquals(expected, updateTVShowsUseCase.execute())
        }
    }
}