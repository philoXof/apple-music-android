package com.example.kelyan_bervin.apple_music_android.ranking.album_ranking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.*
import com.example.kelyan_bervin.apple_music_android.R
import com.example.kelyan_bervin.apple_music_android.api.NetworkManager
import com.example.kelyan_bervin.apple_music_android.data_class.Album
import kotlinx.android.synthetic.main.album_ranking_list.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class AlbumRankingList : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.album_ranking_list, container, false
        )
    }

    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val albumList = arrayListOf<Album>()


        try {
            GlobalScope.launch(Dispatchers.Default) {
                val response = NetworkManager.getTopTenAlbum()

                withContext(Dispatchers.Main) {
                    albumList.addAll(response.album)
                }
            }

        } catch (e: IOException){
            println(e)
        }

        println("------------------------------")
        println(albumList.size)
        println("------------------------------")

        val album1 = Album("1", "e", "album1", "artisteName", "e", "e"," e", "e")
        val album2 = Album("2", "e", "album2", "artisteName", "e", "e"," e", "e")
        val album3 = Album("3", "e", "album3", "artisteName", "e", "e"," e", "e")
        val album4 = Album("4", "e", "album4", "artisteName", "e", "e"," e", "e")
        val album5 = Album("5", "e", "album5", "artisteName", "e", "e"," e", "e")

        albumList.add(album1)
        albumList.add( album2)
        albumList.add(album3)
        albumList.add(album4)
        albumList.add(album5)


        println("------------------------------")
        println(albumList.size)
        println("------------------------------")
        main_list.run {
            layoutManager = LinearLayoutManager(activity)
            adapter = AlbumRankingListAdapter(albumList, object: OnItemClickedListener {
                override fun onItemClicked(idAlbum: String) {
                    Toast.makeText(context, idAlbum, Toast.LENGTH_SHORT).show()

                    /*findNavController().navigate(
                        AlbumRankingListDirections.actionAlbumRankingListToAlbumDetails(idAlbum)
                    )
                     */
                }

            })
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(), DividerItemDecoration.VERTICAL
                )
            )
        }

    }

    
}

