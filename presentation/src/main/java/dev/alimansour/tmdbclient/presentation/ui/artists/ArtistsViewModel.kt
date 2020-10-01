package dev.alimansour.tmdbclient.presentation.ui.artists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class ArtistsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Artists Fragment"
    }
    val text: LiveData<String> = _text
}