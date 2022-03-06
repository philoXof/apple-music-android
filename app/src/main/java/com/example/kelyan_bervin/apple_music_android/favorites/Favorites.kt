package com.example.kelyan_bervin.apple_music_android.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kelyan_bervin.apple_music_android.R
import com.example.kelyan_bervin.apple_music_android.bdd.DatabaseManager
import com.example.kelyan_bervin.apple_music_android.data_class.Album
import com.example.kelyan_bervin.apple_music_android.data_class.Artist
import kotlinx.android.synthetic.main.favorites.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException

class Favorites(): Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.favorites, container, false
        )
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fav_artist_progressBar.visibility = View.VISIBLE
        fav_album_progressBar.visibility = View.VISIBLE

        var favAlbumList: List<Album>
        var favArtistList: List<Artist>

        try {
            GlobalScope.launch {


                val databaseManager = context?.let { DatabaseManager(it) }

                favAlbumList = databaseManager!!.findAllAlbum()

                fav_artist_list.run {
                    layoutManager = LinearLayoutManager(requireContext())
                    adapter = FavoritesAlbumListAdapter(favAlbumList, object: OnFavAlbumClickedListener{
                        override fun onItemClicked(idAlbum: String) {
                            Toast.makeText(context, idAlbum, Toast.LENGTH_SHORT).show()

                            findNavController().navigate(
                                FavoritesDirections.actionFavoritesToAlbumDetails(
                                    idAlbumParam = idAlbum
                                )
                            )
                        }

                    })
                    fav_artist_progressBar.visibility = View.GONE
                }


                favArtistList = databaseManager.findAllArtist()

                fav_album_list.run {
                    layoutManager = LinearLayoutManager(requireContext())
                    adapter = FavoritesArtistListAdapter(favArtistList, object: OnFavArtistClickedListener{
                        override fun onItemClicked(idArtist: String) {
                            Toast.makeText(context, idArtist, Toast.LENGTH_SHORT).show()

                            findNavController().navigate(
                                FavoritesDirections.actionFavoritesToArtistDetails(
                                    idArtistParam = idArtist,
                                    idTrackParam = ""
                                )
                            )

                        }
                    })
                    fav_album_progressBar.visibility = View.GONE
                }


            }

        } catch (e: IOException){
            println(e)
        }



    }
}