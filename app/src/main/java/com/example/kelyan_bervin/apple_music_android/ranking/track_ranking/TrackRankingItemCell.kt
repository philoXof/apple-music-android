package com.example.kelyan_bervin.apple_music_android.ranking.track_ranking

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.track_ranking_item_cell.view.*

class TrackRankingItemCell (v: View): RecyclerView.ViewHolder(v){

    val number: TextView = v.artDetail_track_number
    val cover: ImageView = v.track_ranking_cover
    val track_title: TextView = v.artDetail_track_title
    val track_artist: TextView = v.track_artist

}