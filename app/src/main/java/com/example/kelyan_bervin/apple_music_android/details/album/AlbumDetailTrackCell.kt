package com.example.kelyan_bervin.apple_music_android.details.album

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.album_detail_track_cell.view.*

class AlbumDetailTrackCell (v: View) : RecyclerView.ViewHolder(v) {

    val albumDetailTrackNumber: TextView = v.albumDetail_track_number
    val albumDetailTrackTitle: TextView = v.albumDetail_track_title
    val constraintTrackAlbumDetailCell:ConstraintLayout = v.constraint_track_albumDetail_cell

}
