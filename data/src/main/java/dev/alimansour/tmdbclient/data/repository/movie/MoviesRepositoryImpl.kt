package dev.alimansour.tmdbclient.data.repository.movie

import dev.alimansour.tmdbclient.data.mapper.MovieMapper
import dev.alimansour.tmdbclient.data.mapper.MovieResponseMapper
import dev.alimansour.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import dev.alimansour.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import dev.alimansour.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import dev.alimansour.tmdbclient.domain.model.MovieList.Movie
import dev.alimansour.tmdbclient.domain.repository.MoviesRepository

/**
 * TMDB Client Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- TMDB Client IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class MoviesRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource,
    private val movieResponseMapper: MovieResponseMapper,
    private val movieMapper: MovieMapper
) : MoviesRepository {
    override suspend fun getMovies(): List<Movie>? = getMoviesFromCache()

    override suspend fun updateMovies(): List<Movie>? {
        val newMovieList = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newMovieList.map {
            movieMapper.mapToEntity(it)
        })
        movieCacheDataSource.saveMoviesToCache(newMovieList)
        return newMovieList
    }

    /**
     * Get list of popular movies from TMDB API
     * @return List of Movie objects
     */
    private suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        runCatching {
            val response = movieRemoteDataSource.getMovies()
            if (response.isSuccessful) {
                response.body()?.let {
                    movieList = movieResponseMapper.mapFromEntity(it).movies
                }
            }
        }.onFailure { it.printStackTrace() }
        return movieList
    }

    /**
     * Get list of popular movies from the local database
     * @return List of Movie objects
     */
    private suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>
        runCatching {
            movieList = movieLocalDataSource.getMoviesFromDB().map {
                movieMapper.mapFromEntity(it)
            }
            if (movieList.isNotEmpty()) {
                return movieList
            } else {
                movieList = getMoviesFromAPI()
                movieLocalDataSource.saveMoviesToDB(movieList.map {
                    movieMapper.mapToEntity(it)
                })
            }
        }.onFailure { it.printStackTrace() }

        return movieList
    }

    /**
     * Get list of popular movies from the device cache
     * @return List of Movie objects
     */
    private suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var moviesList: List<Movie>
        runCatching {
            moviesList = movieCacheDataSource.getMoviesFromCache()
        }.onFailure { it.printStackTrace() }
        if (moviesList.isNotEmpty()) {
            return moviesList
        } else {
            moviesList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(moviesList)
        }

        return moviesList
    }
}