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
class UpdateArtistsUseCaseTest {
    private lateinit var updateArtistsUseCase: UpdateArtistsUseCase

    @Before
    fun setUp() {
        val repository = ArtistsRepositoryImpl()
        updateArtistsUseCase = UpdateArtistsUseCase(repository)
    }


    @Test
    fun executeTest() {
        runBlocking {
            // Arrange
            // Act
            val expected = listOf(
                ArtistList.Artist(4, "Fourth Artist", 35.5, "profile_path"),
                ArtistList.Artist(5, "Fifth Artist", 23.0, "profile_path")
            )
            // Assert
            assertEquals(expected, updateArtistsUseCase.execute())
        }
    }
}