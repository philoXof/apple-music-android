package com.example.kelyan_bervin.apple_music_android.details.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kelyan_bervin.apple_music_android.R
import com.example.kelyan_bervin.apple_music_android.data_class.Track
import com.example.kelyan_bervin.apple_music_android.ranking.track_ranking.OnTrackClickedListener

class ArtistDetailTrackListAdapter(private val trackList: List<Track>, private  val listener: OnTrackClickedListener)
                                    : RecyclerView.Adapter<ArtistDetailTrackCell>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistDetailTrackCell {
        return ArtistDetailTrackCell(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.artist_detail_track_cell, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ArtistDetailTrackCell, position: Int) {
        val number = position + 1
        holder.artDetailTrackNumber.text = number.toString()
        holder.artDetailTrackTitle.text = trackList[position].strTrack


        holder.constraintTrackArtDetailCell.setOnClickListener {
            listener.onItemClicked(trackList[position].idAlbum)
        }
    }

    override fun getItemCount(): Int {
        return trackList.size
    }
}