package dev.alimansour.tmdbclient.domain.util

/**
 * PassySports Android Application developed by: Ali Mansour
 * Copyright © 2020 Passy Co. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- PassySports IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
data class ResultWrapper<out T>(
    val status: Status,
    val data: T?,
    val message: String?
) {

    enum class Status { SUCCESS, ERROR, LOADING }

    companion object {
        fun <T> success(data: T?): ResultWrapper<T> {
            return ResultWrapper(Status.SUCCESS, data, null)
        }

        fun <T> error(data: T?, message: String): ResultWrapper<T> {
            return ResultWrapper(Status.ERROR, data, message)
        }

        fun <T> loading(data: T?): ResultWrapper<T> {
            return ResultWrapper(Status.LOADING, data, null)
        }
    }
}