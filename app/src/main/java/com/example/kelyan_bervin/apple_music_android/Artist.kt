package com.example.kelyan_bervin.apple_music_android

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Artist (@PrimaryKey val idArtist: String, val strArtist: String, val strBiographyEN: String)



