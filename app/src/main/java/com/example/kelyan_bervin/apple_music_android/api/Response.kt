package com.example.kelyan_bervin.apple_music_android.api

import com.example.kelyan_bervin.apple_music_android.data_class.Album
import com.example.kelyan_bervin.apple_music_android.data_class.Artist
import com.example.kelyan_bervin.apple_music_android.data_class.Track
import com.google.gson.annotations.SerializedName

data class AlbumResponse(@SerializedName("album") val album: List<Album>)

data class TopTenAlbumResponse(@SerializedName("loved") val album: List<Album>)

data class TopTrackResponse(@SerializedName("loved") val tracks: List<Track>)

data class TrackResponse(@SerializedName("track") val track: List<Track>)

data class ArtistsResponse(@SerializedName("artists") val artist: List<Artist>)