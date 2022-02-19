package com.example.kelyan_bervin.apple_music_android.ranking.track_ranking

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kelyan_bervin.apple_music_android.R
import com.example.kelyan_bervin.apple_music_android.data_class.Track


class TrackRankingListAdapter(val topTrackList: List<Track>): RecyclerView.Adapter<TrackRankingItemCell>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackRankingItemCell {
        return TrackRankingItemCell(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.track_ranking_item_cell, parent, false)
        )
    }

    override fun onBindViewHolder(cell: TrackRankingItemCell, position: Int) {
        //cell.testContent.text = topTrackList[position].idArtist

        val number = position + 1
        cell.number.text = number.toString()
        //cell.cover = topTrackList[position].strTrackThumb
        cell.track_title.text = topTrackList[position].strTrack
        cell.track_artist.text = topTrackList[position].strArtist
    }

    override fun getItemCount(): Int {
        return topTrackList.size
    }


}
