package dev.alimansour.tmdbclient.domain.usecase.artist

import dev.alimansour.tmdbclient.domain.model.ArtistList
import dev.alimansour.tmdbclient.domain.repository.ArtistsRepositoryImpl
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
class GetArtistsUseCaseTest {
    private lateinit var getArtistsUseCase: GetArtistsUseCase

    @Before
    fun setUp() {
        val repository = ArtistsRepositoryImpl()
        getArtistsUseCase = GetArtistsUseCase(repository)
    }


    @Test
    fun executeTest() {
        runBlocking {
            // Arrange
            // Act
            val expected = listOf(
                ArtistList.Artist(1, "First Artist", 45.5, "profile_path"),
                ArtistList.Artist(2, "Second Artist", 32.5, "profile_path"),
                ArtistList.Artist(3, "Third Artist", 39.0, "profile_path")
            )
            // Assert
            assertEquals(expected, getArtistsUseCase.execute())
        }
    }
}