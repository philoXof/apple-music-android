package com.example.kelyan_bervin.apple_music_android.api

import com.example.kelyan_bervin.apple_music_android.Album
import com.google.gson.annotations.SerializedName

data class Response(@SerializedName("response") val album: Album) // passe dans la route mais l'objet Album est vide

//data class Response(@SerializedName("album") val album: Album) // ne passe pas dans la route mais est
                                                                   // conforme aux explications du cours



data class ResponseTest(@SerializedName("response") val product: Product) // passe dans la route mais l'objet Album est vide
