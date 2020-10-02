package dev.alimansour.tmdbclient.presentation.utils

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */

/**
 * Stop refresh for SwipeToRefreshLayout
 */
fun SwipeRefreshLayout.stopRefreshing() {
    if (this.isRefreshing) {
        this.isRefreshing = false
    }
}