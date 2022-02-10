package com.example.kelyan_bervin.apple_music_android.bdd

import androidx.room.*
import com.example.kelyan_bervin.apple_music_android.Album
import com.example.kelyan_bervin.apple_music_android.Artist
import kotlinx.coroutines.flow.Flow



@Dao
interface BddDao{

    //Album
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAlbum(album: Album)

    @Delete
    fun deleteAlbum(album: Album)

    @Query("SELECT * FROM Album")
    fun findAllAlbum() : List<Album>

    @Query("SELECT * FROM Album")
    fun listAlbums() : Flow<List<Album>>

    //Artiste
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addArtist(artist: Artist)

    @Delete
    fun deleteArtist(artist: Artist)

    @Query("SELECT * from Artist")
    fun findAllArtist(): List<Artist>

    @Query("SELECT * FROM Artist")
    fun listArtists() : Flow<List<Artist>>

}


//définition de la BDD
@Database(entities = [Artist::class, Album::class], version = 2)
abstract class AppDataBase: RoomDatabase(){
    abstract fun dao(): BddDao
}
