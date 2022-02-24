package com.example.kelyan_bervin.apple_music_android.favorites

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fav_artist_item_cell.view.*

class FavoritesArtistItemCell (v: View) : RecyclerView.ViewHolder(v) {

    val favArtistProfilePicture: ImageView = v.fav_artist_profile_picture
    val favArtistName: TextView = v.fav_artist_name
    val constraintFavArtistItemCell: ConstraintLayout = v.constraint_fav_artist_item_cell

}