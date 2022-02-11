package com.example.kelyan_bervin.apple_music_android.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {

    val retrofitTest = Retrofit.Builder()
        .baseUrl("https://api.formation-android.fr/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(API::class.java )



    val retrofit = Retrofit.Builder()
        .baseUrl("https://theaudiodb.com/api/v1/json/523532/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(API::class.java )



    suspend fun getAlbum(idAlbum: String): Response {
        return retrofit.getAlbumAsync(idAlbum).await()
    }

    suspend fun getProductTest(barcode: String): ResponseTest {
        return retrofitTest.getProductTest(barcode).await()
    }

}