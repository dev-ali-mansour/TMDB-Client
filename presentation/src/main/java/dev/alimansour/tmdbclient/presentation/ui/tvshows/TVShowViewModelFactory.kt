package dev.alimansour.tmdbclient.presentation.ui.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.alimansour.tmdbclient.domain.usecase.tvshow.GetTVShowsUseCase
import dev.alimansour.tmdbclient.domain.usecase.tvshow.UpdateTVShowsUseCase
import javax.inject.Inject

class TVShowViewModelFactory @Inject constructor(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val updateTVShowsUseCase: UpdateTVShowsUseCase
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TVShowViewModel::class.java)) {
            return TVShowViewModel(getTVShowsUseCase, updateTVShowsUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}