package com.example.kelyan_bervin.apple_music_android.ranking.album_ranking

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kelyan_bervin.apple_music_android.R
import com.example.kelyan_bervin.apple_music_android.data_class.Album

class AlbumRankingListAdapter(val albumList: List<Album>, val listener: OnItemClickedListener) : RecyclerView.Adapter<AlbumRankingItemCell>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumRankingItemCell {
        return AlbumRankingItemCell(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.album_ranking_item_cell, parent, false)
        )
    }

    override fun onBindViewHolder(cell: AlbumRankingItemCell, position: Int) {
        val number = position + 1
        cell.number.text = number.toString()
        //cell.cover = topTrackList[position].strTrackThumb
        cell.album_title.text = albumList[position].strAlbum
        cell.album_artist.text = albumList[position].strArtist

        cell.album_title.setOnClickListener {
            listener.onItemClicked(albumList[position].idAlbum)
        }

    }

    override fun getItemCount(): Int {
        return albumList.size
    }
}