package dev.alimansour.tmdbclient.presentation.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.alimansour.tmdbclient.domain.usecase.movie.GetMoviesUseCase
import dev.alimansour.tmdbclient.domain.usecase.movie.UpdateMoviesUseCase
import javax.inject.Inject

class MovieViewModelFactory @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            return MovieViewModel(getMoviesUseCase, updateMoviesUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}