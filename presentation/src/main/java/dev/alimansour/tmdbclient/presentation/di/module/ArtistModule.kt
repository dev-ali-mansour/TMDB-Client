package dev.alimansour.tmdbclient.presentation.di.module

import dagger.Module
import dagger.Provides
import dev.alimansour.tmdbclient.domain.usecase.artist.GetArtistImagesUseCase
import dev.alimansour.tmdbclient.domain.usecase.artist.GetArtistsUseCase
import dev.alimansour.tmdbclient.domain.usecase.artist.UpdateArtistsUseCase
import dev.alimansour.tmdbclient.presentation.di.ArtistScope
import dev.alimansour.tmdbclient.presentation.ui.artists.ArtistViewModelFactory

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
@Module
object ArtistModule {

    @JvmStatic
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase,
        getArtistImagesUseCase: GetArtistImagesUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase,
            getArtistImagesUseCase
        )
    }
}