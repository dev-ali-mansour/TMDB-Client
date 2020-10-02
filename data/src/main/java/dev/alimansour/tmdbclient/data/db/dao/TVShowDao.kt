package dev.alimansour.tmdbclient.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.alimansour.tmdbclient.data.db.entity.TVShowEntity

@Dao
interface TVShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(TVShowEntities: List<TVShowEntity>)

    @Query("DELETE FROM popular_tvShows")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM popular_tvShows")
    suspend fun getTvShows(): List<TVShowEntity>
}