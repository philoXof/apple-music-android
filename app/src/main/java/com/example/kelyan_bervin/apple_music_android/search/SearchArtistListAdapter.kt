package com.example.kelyan_bervin.apple_music_android.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kelyan_bervin.apple_music_android.R
import com.example.kelyan_bervin.apple_music_android.data_class.Artist
import com.example.kelyan_bervin.apple_music_android.favorites.FavoritesArtistItemCell
import com.squareup.picasso.Picasso

class SearchArtistListAdapter(private val sArtistList: List<Artist>, private val listener: OnArtistClickedListener)
                                            : RecyclerView.Adapter<FavoritesArtistItemCell>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesArtistItemCell {
        return FavoritesArtistItemCell(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fav_artist_item_cell, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FavoritesArtistItemCell, position: Int) {
        Picasso.get().load(sArtistList[position].strArtistThumb).into(holder.favArtistProfilePicture)
        holder.favArtistName.text = sArtistList[position].strArtist

        holder.constraintFavArtistItemCell.setOnClickListener {
            listener.onArtistClickedListener(sArtistList[position].idArtist)
        }
    }

    override fun getItemCount(): Int {
        return sArtistList.size
    }
}