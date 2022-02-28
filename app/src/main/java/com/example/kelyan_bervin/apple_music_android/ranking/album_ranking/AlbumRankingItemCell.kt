package com.example.kelyan_bervin.apple_music_android.ranking.album_ranking

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.album_ranking_item_cell.view.*

class AlbumRankingItemCell (v: View) : RecyclerView.ViewHolder(v) {

    val number: TextView = v.album_ranking_number
    val album_cover: ImageView = v.album_ranking_cover
    val album_title: TextView = v.album_title
    val album_artist: TextView = v.album_artist

}