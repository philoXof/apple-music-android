package com.example.kelyan_bervin.apple_music_android.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kelyan_bervin.apple_music_android.R
import com.example.kelyan_bervin.apple_music_android.data_class.Artist
import com.squareup.picasso.Picasso

class FavoritesArtistListAdapter (private val favArtistList: List<Artist>,
                                  private  val listener: OnFavArtistClickedListener)
                                            :RecyclerView.Adapter<FavoritesArtistItemCell>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesArtistItemCell {
        return FavoritesArtistItemCell(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fav_artist_item_cell, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FavoritesArtistItemCell, position: Int) {

        Picasso.get().load(favArtistList[position].strArtistThumb).into(holder.favArtistProfilePicture)
        holder.favArtistName.text = favArtistList[position].strArtist

        holder.constraintFavArtistItemCell.setOnClickListener {
            listener.onItemClicked(favArtistList[position].idArtist)
        }

    }

    override fun getItemCount(): Int {
        return favArtistList.size
    }
}