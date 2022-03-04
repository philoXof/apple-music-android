package com.example.kelyan_bervin.apple_music_android.search

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kelyan_bervin.apple_music_android.R
import com.example.kelyan_bervin.apple_music_android.api.NetworkManager
import com.example.kelyan_bervin.apple_music_android.data_class.Album
import com.example.kelyan_bervin.apple_music_android.data_class.Artist
import com.example.kelyan_bervin.apple_music_android.ranking.album_ranking.OnItemClickedListener
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.search.*
import kotlinx.coroutines.*

class Search(): Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.search, container, false
        )
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        search_magnifier_button.setOnClickListener {

            if(TextUtils.isEmpty(search_box.text)){
                Toast.makeText(context, "Please enter an artist name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            s_artist_progressBar.visibility = View.VISIBLE
            s_album_progressBar.visibility = View.VISIBLE

            GlobalScope.launch(Dispatchers.Default) {

                val artistName = search_box.text

                val artistResponse = NetworkManager.getArtistByName(artistName.toString())
                if(artistResponse.artist.isNullOrEmpty()){
                    Snackbar.make(view, "$artistName not found. Please retry", Snackbar.LENGTH_LONG).show()
                    s_artist_progressBar.visibility = View.INVISIBLE
                    s_album_progressBar.visibility = View.INVISIBLE
                    cancel()
                }

                val listArtistsSearched = arrayListOf<Artist>()
                val listAlbumsSearched = arrayListOf<Album>()

                withContext(Dispatchers.Main){

                    listArtistsSearched.addAll(artistResponse.artist)

                    search_artist_list.run {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = SearchArtistListAdapter(listArtistsSearched, object:OnArtistClickedListener {
                            override fun onArtistClickedListener(idArtist: String) {
                                Toast.makeText(context, idArtist, Toast.LENGTH_SHORT).show()

                            }
                        })
                        s_artist_progressBar.visibility = View.INVISIBLE
                    }


                    val albumResponse = NetworkManager.getAllAlbumByArtistName(artistName.toString())
                    if(albumResponse.album.isNullOrEmpty()){
                        Snackbar.make(view, "$artistName has not made an album yet", Snackbar.LENGTH_SHORT).show()
                        cancel()
                    }


                    listAlbumsSearched.addAll(albumResponse.album)

                    search_album_list.run {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = SearchAlbumListAdapter(listAlbumsSearched, object: OnItemClickedListener{
                            override fun onItemClicked(idAlbum: String) {
                                Toast.makeText(context, idAlbum, Toast.LENGTH_SHORT).show()

                            }
                        })
                        s_album_progressBar.visibility = View.INVISIBLE
                    }
                }
            }
        }


        cancel_button.setOnClickListener {
            search_box.text.clear()
        }


    }

}