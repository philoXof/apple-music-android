package com.example.kelyan_bervin.apple_music_android

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.album_ranking_item_cell.view.*

class AlbumRankingItemCell (v: View) : RecyclerView.ViewHolder(v) {

    val text: TextView = v.text_cell
}