package com.example.kelyan_bervin.apple_music_android.bdd

import androidx.room.*
import com.example.kelyan_bervin.apple_music_android.Album
import com.example.kelyan_bervin.apple_music_android.Artist



@Dao
interface BddDao{

    //Album
    @Insert
    fun addAlbum(album: Album)

    @Delete
    fun deleteAlbum(album: Album)

    @Query("SELECT * FROM album")
    fun findAllAlbum() : List<Album>


    //Artiste
    @Insert
    fun addArtist(artist: Artist)

    @Delete
    fun deleteArtist(artist: Artist)

    @Query("SELECT * from artist")
    fun findAllArtist(): List<Artist>

}


//définition de la BDD
@Database(entities = [Album::class], version = 1)
abstract class AppDataBase: RoomDatabase(){
    abstract fun dao(): BddDao
}
