package com.example.kelyan_bervin.apple_music_android.favorites

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fav_album_item_cell.view.*

class FavoritesAlbumItemCell (v: View) : RecyclerView.ViewHolder(v){

    val favAlbumCover: ImageView = v.artDetail_album_cover
    val favAlbumTitle: TextView = v.fav_album_title
    val favAlbumArtistName: TextView = v.fav_album_artist_name
    val constraintFavAlbumItemCell: ConstraintLayout = v.constraint_artDetail_album_item_cell


}