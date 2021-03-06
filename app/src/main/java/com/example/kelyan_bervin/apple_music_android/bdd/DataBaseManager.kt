package com.example.kelyan_bervin.apple_music_android.bdd

import android.content.Context
import androidx.room.Room
import com.example.kelyan_bervin.apple_music_android.data_class.Album
import com.example.kelyan_bervin.apple_music_android.data_class.Artist
import kotlinx.coroutines.flow.Flow

class DatabaseManager(context: Context) {

    private val db = Room.databaseBuilder(
        context,
        AppDataBase::class.java,
        "db_projet_android"
    ).build()

    fun addAlbum(album: Album){
        return db.dao().addAlbum(album)
    }

    fun deleteAlbum(album: Album) {
        return db.dao().deleteAlbum(album)
    }

    fun findAllAlbum(): List<Album> {
        return db.dao().findAllAlbum()
    }

    suspend fun listenToAlbumChanges(): Flow<List<Album>> {
        return db.dao().listAlbums()
    }

    fun addArtist(artist: Artist){
        return db.dao().addArtist(artist)
    }

    fun deleteArtist(artist: Artist) {
        return db.dao().deleteArtist(artist)
    }

    fun findAllArtist(): List<Artist> {
        return db.dao().findAllArtist()
    }

    suspend fun listenToArtistChanges(): Flow<List<Artist>> {
        return db.dao().listArtists()
    }

}