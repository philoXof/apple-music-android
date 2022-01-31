package com.example.kelyan_bervin.apple_music_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AlbumRankingList : Fragment(){

    /*companion object{
        fun newInstance(album: Album) : AlbumDetails {
            val fragment = AlbumDetails()
            val args = bundleOf("album" to album)
            fragment.arguments = args


            return fragment
        }
    }
    */



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
        //potentiellement ici qu'il faut call l'API pour récupérer la liste d'album
        /*val albumList = List(30) { album ->
            "${

            }"
        }*/
        val track1 = Track("track1", "Moi")
        val track2 = Track("track2", "Toi")
        val track3 = Track("track3", "Eux")
        val trackList = listOf(track1, track2, track3)

        val track4 = Track("track4", "Moi")
        val track5 = Track("track5", "Toi")
        val track6 = Track("track6", "Eux")
        val trackList2 = listOf(track4, track5, track6)

        val album1 = Album("album1", "zemlfkjz", trackList)
        val album2 = Album("album2", "sdvsdsv", trackList2)


        val albumList = listOf(album1, album2)


        val main_list = view.findViewById<RecyclerView>(R.id.main_list)
        main_list.run {
            GridLayoutManager(requireContext(), 3)

            ListAdapter(albumList, object : OnItemClickedListener {
                override fun onItemClicked(album: String) {

                    findNavController().navigate(
                        AlbumRankingListDirections.actionAlbumRankingListToAlbumDetails(
                            album
                        )
                    )
                }
            })
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
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
            //boucler sur les cell pour afficher les noms des albums
            cell.text.text = albumList[position].getName()


            cell.text.setOnClickListener {
                listener.onItemClicked(albumList[position].getName())
            }

        }

        override fun getItemCount(): Int {
            return albumList.size
        }
    }


}

interface OnItemClickedListener {
    fun onItemClicked(album: String)
}