package com.example.kelyan_bervin.apple_music_android.details.album

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kelyan_bervin.apple_music_android.R
import com.example.kelyan_bervin.apple_music_android.api.NetworkManager
import com.example.kelyan_bervin.apple_music_android.bdd.DatabaseManager
import com.example.kelyan_bervin.apple_music_android.data_class.Track
import com.example.kelyan_bervin.apple_music_android.ranking.track_ranking.OnTrackClickedListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.album_details.*
import kotlinx.android.synthetic.main.album_details.album_title
import kotlinx.android.synthetic.main.album_details.artist_name
import kotlinx.android.synthetic.main.album_details.like_button
import kotlinx.android.synthetic.main.artist_details.*
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

        val trackList = arrayListOf<Track>()

        try {
            GlobalScope.launch(Dispatchers.Default) {

                //val idAlbum = AlbumDetailsArgs.fromBundle(requireArguments()).idAlbumParam
                //println("idAlbum = $idAlbum")

                val idAlbum = "2115888"

                val albumResponse = NetworkManager.getAlbumById(idAlbum)

                val trackResponse = NetworkManager.getAllTracksByIdAlbum(idAlbum)

                withContext(Dispatchers.Main) {

                    //Picasso.get().load(albumResponse.album[0].strAlbumThumb).into(banner.background)
                    artist_name.text = albumResponse.album[0].strArtist
                    Picasso.get().load(albumResponse.album[0].strAlbumThumb).into(album_cover)
                    album_title.text = albumResponse.album[0].strAlbum
                    nb_title.text = trackResponse.track.size.toString()
                    nb_stars.text = albumResponse.album[0].intScore
                    nb_votes.text = albumResponse.album[0].intScoreVotes
                    album_description.text = albumResponse.album[0].strDescriptionEN


                    trackList.addAll(trackResponse.track)

                    track_list.run{
                        layoutManager = LinearLayoutManager(requireContext())
                        adapter = AlbumDetailTrackLisListAdapter(trackList, object : OnTrackClickedListener {
                            override fun onItemClicked(idTrack: String) {
                                Toast.makeText(context, idAlbum, Toast.LENGTH_SHORT).show()
                            }
                        })
                    }

                }
            }
        } catch (e: IOException){
            println(e)
        }


        like_button.setOnClickListener {
            GlobalScope.launch {

                //val idAlbum = AlbumDetailsArgs.fromBundle(requireArguments()).idAlbumParam
                //println("idAlbum = $idAlbum")

                val albumResponse = NetworkManager.getAlbumById("2115888")
                //val albumResponse = NetworkManager.getAlbumById(idAlbum)

                val databaseManager = context?.let { it1 -> DatabaseManager(it1) }

                databaseManager?.addAlbum(albumResponse.album[0])

                like_button.setImageResource(R.drawable.ic_like_on)
            }
        }


    }


}