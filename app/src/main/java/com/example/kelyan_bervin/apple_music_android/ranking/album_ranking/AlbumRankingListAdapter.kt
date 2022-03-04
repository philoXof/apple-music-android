package com.example.kelyan_bervin.apple_music_android.ranking.album_ranking

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.kelyan_bervin.apple_music_android.R
import com.example.kelyan_bervin.apple_music_android.data_class.Album
import com.squareup.picasso.Picasso

class AlbumRankingListAdapter(private val albumList: List<Album>, private val listener: OnItemClickedListener) : RecyclerView.Adapter<AlbumRankingItemCell>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumRankingItemCell {
        return AlbumRankingItemCell(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.album_ranking_item_cell, parent, false)
        )
    }

    override fun onBindViewHolder(cell: AlbumRankingItemCell, position: Int) {
        val number = position + 1
        cell.number.text = number.toString()
        Picasso.get().load(albumList[position].strAlbumThumb).into(cell.album_cover)
        cell.album_title.text = albumList[position].strAlbum
        cell.album_artist.text = albumList[position].strArtist

        cell.album_title.setOnClickListener {
            /*findNavController(it).navigate(
                AlbumRankingListDirections.actionAlbumRankingListToAlbumDetails(
                    idAlbumParam = albumList[position].idAlbum
                )
            )*/

        listener.onItemClicked(albumList[position].idAlbum)
        }

    }

    override fun getItemCount(): Int {
        return albumList.size
    }
}