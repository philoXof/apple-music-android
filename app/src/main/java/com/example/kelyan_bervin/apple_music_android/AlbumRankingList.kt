package com.example.kelyan_bervin.apple_music_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
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
        /*
        GlobalScope.launch(Dispatchers.Default) {
            val response = NetworkManager.getAlbum("2115888")

            withContext(Dispatchers.Main) {
                val albumList = response.album
            }
        }
        */

        val album1 = Album("album1", "zemlfkjz", "sege", "ssdb ", "Je suis la descritption 1")
        val album2 = Album("album2", "sdvsdsv","vdfv", "ezfz ", "Je suis la descritption 2")
        val album3 = Album("album2", "sdvsdsv","vdfv", "ezfz ", "Je suis la descritption 3")
        val album4 = Album("album2", "sdvsdsv","vdfv", "ezfz ", "Je suis la descritption 4")

        val albumList = listOf(album1, album2, album3, album4)


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
                DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL
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
            cell.text.text = albumList[position].strAlbum


            cell.text.setOnClickListener {
                listener.onItemClicked(albumList[position].strAlbum)
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