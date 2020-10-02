package dev.alimansour.tmdbclient.presentation.ui.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.alimansour.tmdbclient.domain.usecase.artist.GetArtistImagesUseCase
import dev.alimansour.tmdbclient.domain.usecase.artist.GetArtistsUseCase
import dev.alimansour.tmdbclient.domain.usecase.artist.UpdateArtistsUseCase
import javax.inject.Inject

class ArtistViewModelFactory @Inject constructor(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase,
    private val getArtistImagesUseCase: GetArtistImagesUseCase
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArtistViewModel::class.java)) {
            return ArtistViewModel(
                getArtistsUseCase,
                updateArtistsUseCase,
                getArtistImagesUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}