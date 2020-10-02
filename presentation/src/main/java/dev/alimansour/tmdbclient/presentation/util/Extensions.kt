package dev.alimansour.tmdbclient.presentation.util

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */

/**
 * Start refreshing for SwipeToRefreshLayout
 */
fun SwipeRefreshLayout.startRefreshing() {
    post { isRefreshing = true }
}

/**
 * Stop refreshing for SwipeToRefreshLayout
 */
fun SwipeRefreshLayout.stopRefreshing() {
    post { if (isRefreshing) isRefreshing = false }
}
