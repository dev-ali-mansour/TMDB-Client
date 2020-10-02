package dev.alimansour.tmdbclient.data.mapper

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
interface Mapper<E, D> {

    fun mapFromEntity(type: E): D

    fun mapToEntity(type: D): E

}
