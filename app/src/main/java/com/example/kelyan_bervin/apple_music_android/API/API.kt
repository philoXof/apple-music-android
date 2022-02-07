package com.example.kelyan_bervin.apple_music_android.API

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface API {

    @GET("album.php?m=")
    fun getAlbum(@Query("idAlbum") idAlbum: String): Deferred<Response>
}