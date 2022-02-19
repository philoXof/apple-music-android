package com.example.kelyan_bervin.apple_music_android.data_class

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Artist (@PrimaryKey val idArtist: String, val strArtist: String, val strGenre:String,
                   val strBiographyEN: String, val strCountry: String, val strArtistThumb: String)



