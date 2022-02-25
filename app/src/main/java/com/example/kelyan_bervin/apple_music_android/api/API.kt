package com.example.kelyan_bervin.apple_music_android.api

import kotlinx.coroutines.Deferred
import retrofit2.http.Query


interface API {

    /************ Album ************/
    @retrofit2.http.GET("album.php")
    fun getAlbumByIdAsync(@Query("m") idAlbum: String): Deferred<AlbumResponse>

    @retrofit2.http.GET("album.php")
    fun getAllAlbumByIdArtistAsync(@Query("i") idArtist: String): Deferred<AlbumResponse>

    @retrofit2.http.GET("searchalbum.php")
    fun getAllAlbumByArtistNameAsync(@Query("s") artistName: String): Deferred<AlbumResponse>

    @retrofit2.http.GET("mostloved.php?format=album")
    fun getTopTenAlbumAsync(): Deferred<TopTenAlbumResponse>

    @retrofit2.http.GET("searchalbum.php")
    fun getAlbumByArtistAndAlbumNameAsync(@Query("s") artistName: String, @Query("a") albumName: String): Deferred<AlbumResponse>


    /************ Track ************/
    @retrofit2.http.GET("track.php")
    fun getAllTracksByIdAlbumAsync(@Query("m") idArtist: String): Deferred<TrackResponse>

    @retrofit2.http.GET("mostloved.php?format=track")
    fun getTopTrackAsync(): Deferred<TopTrackResponse>


    /************ Artist ************/
    @retrofit2.http.GET("search.php")
    fun getArtistByNameAsync(@Query("s") artistName: String): Deferred<ArtistsResponse>

    @retrofit2.http.GET("artist.php")
    fun getArtistByIdAsync(@Query("i") idArtist: String): Deferred<ArtistsResponse>

}