package com.example.kelyan_bervin.apple_music_android.details.artist

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.artist_detail_album_cell.view.*

class ArtistDetailAlbumCell (v: View) : RecyclerView.ViewHolder(v){

    val artDetailAlbumCover: ImageView = v.artDetail_album_cover
    val artDetailAlbumTitle: TextView = v.artDetail_album_title
    val artDetailAlbumArtistName: TextView = v.artDetail_album_artist_name
    val constraintArtDetailAlbumItemCell: ConstraintLayout = v.constraint_artDetail_album_item_cell
}