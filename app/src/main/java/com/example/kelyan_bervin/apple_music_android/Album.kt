package com.example.kelyan_bervin.apple_music_android

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Album(@PrimaryKey val idAlbum: String, val idArtist: String , val strAlbum: String, val strArtist: String,
                 val strDescriptionEN: String)