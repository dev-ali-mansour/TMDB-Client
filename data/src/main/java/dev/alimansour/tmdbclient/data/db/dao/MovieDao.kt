package dev.alimansour.tmdbclient.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.alimansour.tmdbclient.data.db.entity.MovieEntity

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<MovieEntity>)

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM popular_movies")
    suspend fun getMovies(): List<MovieEntity>
}