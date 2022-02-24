package com.example.kelyan_bervin.apple_music_android.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kelyan_bervin.apple_music_android.R
import com.example.kelyan_bervin.apple_music_android.data_class.Album
import com.squareup.picasso.Picasso

class FavoritesAlbumListAdapter(private val favAlbumList: List<Album>,
                                private  val listener: OnFavAlbumClickedListener)
                                                    : RecyclerView.Adapter<FavoritesAlbumItemCell>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesAlbumItemCell {
        return FavoritesAlbumItemCell(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fav_album_item_cell, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FavoritesAlbumItemCell, position: Int) {
        Picasso.get().load(favAlbumList[position].strAlbumThumb).into(holder.favAlbumCover)
        holder.favAlbumTitle.text = favAlbumList[position].strAlbum
        holder.favAlbumArtistName.text = favAlbumList[position].strArtist


        holder.constraintFavAlbumItemCell.setOnClickListener {
            listener.onItemClicked(favAlbumList[position].idAlbum)
        }
    }

    override fun getItemCount(): Int {
        return favAlbumList.size
    }
}