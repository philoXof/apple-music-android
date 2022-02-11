package com.example.kelyan_bervin.apple_music_android.api

import kotlinx.coroutines.Deferred
import retrofit2.http.Query




data class Product(val name: String, val altName: String, val barcode: String)


interface API {

    @retrofit2.http.GET("album.php")
    fun getAlbumAsync(@Query("m") idAlbum: String): Deferred<Response>


    @retrofit2.http.GET("getProduct")
    fun getProductTest(@Query("barcode") barcode: String): Deferred<ResponseTest>
}