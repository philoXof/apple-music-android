package com.example.kelyan_bervin.apple_music_android.api

import com.example.kelyan_bervin.apple_music_android.Album
import com.google.gson.annotations.SerializedName

data class Response(@SerializedName("album") val album: List<Album>)
