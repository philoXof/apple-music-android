package com.example.kelyan_bervin.apple_music_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kelyan_bervin.apple_music_android.api.NetworkManager
import kotlinx.android.synthetic.main.album_ranking_list.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

        var albumList = listOf<Album>()

        GlobalScope.launch(Dispatchers.Default) {
            val response = NetworkManager.getTopTenAlbum()

            withContext(Dispatchers.Main) {
                albumList = response.album
            }
        }

        main_list.run {
            layoutManager = LinearLayoutManager(activity)
            adapter = ListAdapter(albumList, object: OnItemClickedListener {
                override fun onItemClicked(idAlbum: String) {

                }
            })
        }

    }


    class ListAdapter(val albumList: List<Album>, val listener: OnItemClickedListener) : RecyclerView.Adapter<AlbumRankingItemCell>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumRankingItemCell {

            return AlbumRankingItemCell(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.album_ranking_item_cell, parent, false)
            )
        }

        override fun onBindViewHolder(cell: AlbumRankingItemCell, position: Int) {
            cell.text.text = albumList[position].strAlbum


            cell.text.setOnClickListener {
                listener.onItemClicked(albumList[position].idAlbum)
            }

        }

        override fun getItemCount(): Int {
            return albumList.size
        }
    }


}

interface OnItemClickedListener {
    fun onItemClicked(idAlbum: String)
}