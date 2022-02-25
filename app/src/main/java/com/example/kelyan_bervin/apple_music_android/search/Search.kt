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
import kotlinx.android.synthetic.main.search.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

            GlobalScope.launch(Dispatchers.Default) {

                val artistName = search_box.text

                val artistResponse = NetworkManager.getArtistByName(artistName.toString())
                //TODO : Ne passe pas dans le if
                if(artistResponse.equals(null)){
                    Toast.makeText(context, "$artistName not found", Toast.LENGTH_SHORT).show()
                    return@launch
                }

                val albumResponse = NetworkManager.getAllAlbumByArtistName(artistName.toString())
                //TODO: Ne passe pas dans le if
                if(albumResponse.equals(null)){
                    Toast.makeText(context, "$artistName has not made an album yet", Toast.LENGTH_SHORT).show()
                    return@launch
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
                    }


                    listAlbumsSearched.addAll(albumResponse.album)

                    search_album_list.run {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = SearchAlbumListAdapter(listAlbumsSearched, object: OnItemClickedListener{
                            override fun onItemClicked(idAlbum: String) {
                                Toast.makeText(context, idAlbum, Toast.LENGTH_SHORT).show()

                            }
                        })
                    }
                }
            }
        }


    }

}