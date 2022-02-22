package com.example.kelyan_bervin.apple_music_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kelyan_bervin.apple_music_android.api.NetworkManager
import com.example.kelyan_bervin.apple_music_android.bdd.DatabaseManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.artiste_details.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class ArtistDetails(): Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.artiste_details,
            container,
            false
        )
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        try {
            GlobalScope.launch(Dispatchers.Default) {

                val artistResponse = NetworkManager.getArtistById("112024")
                val albumResponse = NetworkManager.getAllAlbumByIdArtist("112024")

                withContext(Dispatchers.Main) {
                    Picasso.get().load(artistResponse.artist[0].strArtistThumb).into(artiste_image)
                    artistResponse.artist[0].strArtist
                    artistResponse.artist[0].strCountry
                    artistResponse.artist[0].strGenre
                    artistResponse.artist[0].strBiographyEN
                    albumResponse.album.size.toString()
                }
            }
        } catch (e: IOException){
            println(e)
        }



        like_button.setOnClickListener {
            GlobalScope.launch {
                val artistResponse = NetworkManager.getArtistById("112024")

                val databaseManager = context?.let { it1 -> DatabaseManager(it1) }

                databaseManager?.addArtist(artistResponse.artist[0])
            }
        }


    }


}