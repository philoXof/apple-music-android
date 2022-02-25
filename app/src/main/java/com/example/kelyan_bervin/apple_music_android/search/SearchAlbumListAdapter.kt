package com.example.kelyan_bervin.apple_music_android.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kelyan_bervin.apple_music_android.R
import com.example.kelyan_bervin.apple_music_android.data_class.Album
import com.example.kelyan_bervin.apple_music_android.favorites.FavoritesAlbumItemCell
import com.example.kelyan_bervin.apple_music_android.ranking.album_ranking.OnItemClickedListener
import com.squareup.picasso.Picasso

class SearchAlbumListAdapter(private val listAlbumsSearched: List<Album>, private val listener: OnItemClickedListener) 
                                            : RecyclerView.Adapter<FavoritesAlbumItemCell>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesAlbumItemCell {
        return FavoritesAlbumItemCell(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fav_album_item_cell, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FavoritesAlbumItemCell, position: Int) {
        Picasso.get().load(listAlbumsSearched[position].strAlbumThumb).into(holder.favAlbumCover)
        holder.favAlbumTitle.text = listAlbumsSearched[position].strAlbum
        holder.favAlbumArtistName.text = listAlbumsSearched[position].strArtist


        holder.constraintFavAlbumItemCell.setOnClickListener {
            listener.onItemClicked(listAlbumsSearched[position].idAlbum)
        }
    }

    override fun getItemCount(): Int {
        return listAlbumsSearched.size
    }

}
