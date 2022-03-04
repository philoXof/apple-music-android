package com.example.kelyan_bervin.apple_music_android.details.album

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kelyan_bervin.apple_music_android.R
import com.example.kelyan_bervin.apple_music_android.data_class.Track
import com.example.kelyan_bervin.apple_music_android.ranking.track_ranking.OnTrackClickedListener

class AlbumDetailTrackLisListAdapter (private val trackList: List<Track>, private val listener: OnTrackClickedListener)
                                        : RecyclerView.Adapter<AlbumDetailTrackCell>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumDetailTrackCell {
        return AlbumDetailTrackCell(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.album_detail_track_cell, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AlbumDetailTrackCell, position: Int) {
        val number = position + 1
        holder.albumDetailTrackNumber.text = number.toString()
        holder.albumDetailTrackTitle.text = trackList[position].strTrack

        holder.constraintTrackAlbumDetailCell.setOnClickListener {
            listener.onItemClicked(trackList[position].idAlbum)
        }
    }

    override fun getItemCount(): Int {
        return trackList.size
    }
}