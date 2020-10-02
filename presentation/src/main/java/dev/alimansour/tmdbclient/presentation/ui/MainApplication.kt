package dev.alimansour.tmdbclient.presentation.ui

import androidx.multidex.MultiDexApplication
import dev.alimansour.tmdbclient.presentation.di.component.AppComponent
import dev.alimansour.tmdbclient.presentation.di.component.DaggerAppComponent

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
open class MainApplication : MultiDexApplication() {

    // Instance of the AppComponent that will be used by all the Activities in the project
    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    open fun initializeComponent(): AppComponent {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        return DaggerAppComponent.builder().context(applicationContext).build()
    }
}