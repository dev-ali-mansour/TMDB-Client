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
class GetMoviesUseCaseTest {
    private lateinit var getTVShowsUseCase: GetTVShowsUseCase

    @Before
    fun setUp() {
        val repository = TVShowsRepositoryImpl()
        getTVShowsUseCase = GetTVShowsUseCase(repository)
    }


    @Test
    fun executeTest() {
        runBlocking {
            // Arrange
            // Act
            val expected = listOf(
                TvShowList.TvShow("01-1-2020", 1, "First Show", "Overview", "poster_path", 73.5),
                TvShowList.TvShow("01-2-2020", 2, "Second Show", "Overview", "poster_path", 53.5),
                TvShowList.TvShow("01-3-2020", 3, "Third Show", "Overview", "poster_path", 65.5),
            )
            // Assert
            assertEquals(expected, getTVShowsUseCase.execute())
        }
    }
}