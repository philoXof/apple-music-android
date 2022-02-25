package com.example.kelyan_bervin.apple_music_android.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://theaudiodb.com/api/v1/json/523532/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(API::class.java )


    /************ Album ************/
    suspend fun getAlbumById(idAlbum: String): AlbumResponse {
        return retrofit.getAlbumByIdAsync(idAlbum).await()
    }

    suspend fun getAllAlbumByIdArtist(idArtist: String): AlbumResponse {
        return retrofit.getAllAlbumByIdArtistAsync(idArtist).await()
    }

    suspend fun getAllAlbumByArtistName(artistName: String): AlbumResponse {
        return retrofit.getAllAlbumByArtistNameAsync(artistName).await()
    }

    suspend fun getAlbumByArtistAndAlbumName(artistName: String, albumName: String): AlbumResponse{
        return retrofit.getAlbumByArtistAndAlbumNameAsync(artistName, albumName).await()
    }

    suspend fun getTopTenAlbum(): TopTenAlbumResponse {
        return retrofit.getTopTenAlbumAsync().await()
    }

    /************ Track ************/
    suspend fun getAllTracksByIdAlbum(idAlbum: String): TrackResponse {
        return retrofit.getAllTracksByIdAlbumAsync(idAlbum).await()
    }

    suspend fun getTopTrack(): TopTrackResponse {
        return retrofit.getTopTrackAsync().await()
    }

    /************ Artist ************/
    suspend fun getArtistByName(artistName: String): ArtistsResponse {
        return retrofit.getArtistByNameAsync(artistName).await()
    }

    suspend fun getArtistById(idArtist: String): ArtistsResponse {
        return retrofit.getArtistByIdAsync(idArtist).await()
    }

}