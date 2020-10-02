package dev.alimansour.tmdbclient.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.alimansour.tmdbclient.data.db.entity.ArtistEntity

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artists: List<ArtistEntity>)

    @Query("DELETE FROM popular_artists")
    suspend fun deleteAllArtists()

    @Query("SELECT * FROM popular_artists")
    suspend fun getArtists(): List<ArtistEntity>
}