package com.example.kelyan_bervin.apple_music_android.data_class

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Album(@PrimaryKey val idAlbum: String, val idArtist: String , val strAlbum: String, val strArtist: String,
                 val strAlbumThumb: String, val strDescriptionEN: String, val intScore: String, val intScoreVotes: String)