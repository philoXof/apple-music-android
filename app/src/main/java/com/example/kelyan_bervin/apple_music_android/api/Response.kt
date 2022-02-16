package com.example.kelyan_bervin.apple_music_android.api

import com.example.kelyan_bervin.apple_music_android.Album
import com.example.kelyan_bervin.apple_music_android.Artist
import com.example.kelyan_bervin.apple_music_android.Track
import com.google.gson.annotations.SerializedName

data class AlbumResponse(@SerializedName("album") val album: List<Album>)

data class TrackResponse(@SerializedName("track") val track: List<Track>)

data class ArtistsResponse(@SerializedName("artists") val artist: List<Artist>)