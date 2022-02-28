package com.example.kelyan_bervin.apple_music_android.details.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kelyan_bervin.apple_music_android.R
import com.example.kelyan_bervin.apple_music_android.data_class.Album
import com.example.kelyan_bervin.apple_music_android.ranking.album_ranking.OnItemClickedListener
import com.squareup.picasso.Picasso

class ArtistDetailAlbumListAdapter(private val albumList: List<Album>, private  val listener: OnItemClickedListener)
                                : RecyclerView.Adapter<ArtistDetailAlbumCell>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistDetailAlbumCell {
        return ArtistDetailAlbumCell(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.artist_detail_album_cell, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ArtistDetailAlbumCell, position: Int) {
        Picasso.get().load(albumList[position].strAlbumThumb).into(holder.artDetailAlbumCover)
        holder.artDetailAlbumTitle.text = albumList[position].strAlbum
        holder.artDetailAlbumArtistName.text = albumList[position].strArtist


        holder.constraintArtDetailAlbumItemCell.setOnClickListener {
            listener.onItemClicked(albumList[position].idAlbum)
        }
    }

    override fun getItemCount(): Int {
        return albumList.size
    }


}