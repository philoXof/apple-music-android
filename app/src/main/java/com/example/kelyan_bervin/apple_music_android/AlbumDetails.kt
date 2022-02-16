package com.example.kelyan_bervin.apple_music_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kelyan_bervin.apple_music_android.api.NetworkManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.album_details.*
import kotlinx.coroutines.*
import java.io.IOException

class AlbumDetails() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.album_details,
            container,
            false
        )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        try {
            GlobalScope.launch(Dispatchers.Default) {

                val albumResponse = NetworkManager.getAlbumById("2115888")

                val trackResponse = NetworkManager.getAllTracksByIdAlbum("2115888")

                withContext(Dispatchers.Main) {
                    //banner
                    //Picasso.get().load(response.album[0].strAlbumThumb).into(banner.setBackgroundColor())
                    artist_name.text = albumResponse.album[0].strArtist
                    Picasso.get().load(albumResponse.album[0].strAlbumThumb).into(album_cover)
                    album_title.text = albumResponse.album[0].strAlbum
                    nb_title.text = trackResponse.track.size.toString()
                    nb_stars.text = albumResponse.album[0].intScore
                    nb_votes.text = albumResponse.album[0].intScoreVotes
                    album_description.text = albumResponse.album[0].strDescriptionEN
                    //title_list.

                }
            }
        } catch (e: IOException){
            println(e)
        }
    }


}