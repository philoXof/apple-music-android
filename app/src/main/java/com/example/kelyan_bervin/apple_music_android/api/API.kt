package com.example.kelyan_bervin.apple_music_android.api

import kotlinx.coroutines.Deferred
import retrofit2.http.Query


interface API {

    @retrofit2.http.GET("album.php")
    fun getAlbumAsync(@Query("m") idAlbum: String): Deferred<Response>

}