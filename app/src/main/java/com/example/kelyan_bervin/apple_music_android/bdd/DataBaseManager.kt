package com.example.kelyan_bervin.apple_music_android.bdd

import android.content.Context
import androidx.room.Room
import com.example.kelyan_bervin.apple_music_android.Album
import com.example.kelyan_bervin.apple_music_android.Artist

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


    fun addArtist(artist: Artist){
        return db.dao().addArtist(artist)
    }

    fun deleteArtist(artist: Artist) {
        return db.dao().deleteArtist(artist)
    }

    fun findAllArtist(): List<Artist> {
        return db.dao().findAllArtist()
    }

}