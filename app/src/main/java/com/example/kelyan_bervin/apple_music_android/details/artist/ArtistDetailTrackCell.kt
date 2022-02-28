package com.example.kelyan_bervin.apple_music_android.details.artist

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.artist_detail_track_cell.view.*

class ArtistDetailTrackCell (v: View) : RecyclerView.ViewHolder(v){

    val artDetailTrackNumber: TextView = v.artDetail_track_number
    val artDetailTrackTitle: TextView = v.artDetail_track_title
    val constraintTrackArtDetailCell: ConstraintLayout = v.constraint_track_artDetail_cell
}