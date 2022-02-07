package com.example.kelyan_bervin.apple_music_android.API

import com.example.kelyan_bervin.apple_music_android.Album
import com.google.gson.annotations.SerializedName

data class Response(@SerializedName("response") val album: Album)