package com.example.kelyan_bervin.apple_music_android.details.artist

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
import com.example.kelyan_bervin.apple_music_android.data_class.Album
import com.example.kelyan_bervin.apple_music_android.data_class.Track
import com.example.kelyan_bervin.apple_music_android.ranking.album_ranking.OnItemClickedListener
import com.example.kelyan_bervin.apple_music_android.ranking.track_ranking.OnTrackClickedListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.artist_details.*
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
            R.layout.artist_details,
            container,
            false
        )
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val albumList = arrayListOf<Album>()
        val trackList = arrayListOf<Track>()

        try {
            GlobalScope.launch(Dispatchers.Default) {

                val artistResponse = NetworkManager.getArtistById("112024")

                val albumResponse = NetworkManager.getAllAlbumByIdArtist("112024")

                val trackResponse = NetworkManager.getTenLovedTrackByArtistName(artistResponse.artist[0].strArtist)

                withContext(Dispatchers.Main) {

                    Picasso.get().load(artistResponse.artist[0].strArtistThumb).into(artist_image)
                    artist_name.text = artistResponse.artist[0].strArtist
                    artist_country.text = artistResponse.artist[0].strCountry
                    artist_genre.text = artistResponse.artist[0].strGenre
                    artist_description.text = artistResponse.artist[0].strBiographyEN
                    album_title.text = albumResponse.album.size.toString()


                    albumList.addAll(albumResponse.album)

                    album_list.run{
                        layoutManager = LinearLayoutManager(requireContext())
                        adapter = ArtistDetailAlbumListAdapter(albumList, object : OnItemClickedListener {
                            override fun onItemClicked(idAlbum: String) {
                                Toast.makeText(context, idAlbum, Toast.LENGTH_SHORT).show()
                            }
                        })
                    }


                    trackList.addAll(trackResponse.track)

                    track_list.run{
                        layoutManager = LinearLayoutManager(requireContext())
                        adapter = ArtistDetailTrackListAdapter(trackList, object : OnTrackClickedListener {
                            override fun onItemClicked(idTrack: String) {
                                Toast.makeText(context, idTrack, Toast.LENGTH_SHORT).show()
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
                val artistResponse = NetworkManager.getArtistById("112024")

                val databaseManager = context?.let { it1 -> DatabaseManager(it1) }

                databaseManager?.addArtist(artistResponse.artist[0])
            }
        }


    }


}