package com.example.kelyan_bervin.apple_music_android

import androidx.room.Entity


/*class Album constructor( name: String, description: String, val trackList: List<Track>){

    fun getName(): String{
        return this.getName()
    }

    fun getDescription(): String{
        return this.getDescription()
    }

}*/

@Entity()
data class Album(val idAlbum: String, val idArtist: String, val strAlbum: String, val strArtist: String,
                val strDescriptionEN: String)