package com.example.kelyan_bervin.apple_music_android

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.track_ranking_list.view.*


class TrackRankingListAdapter(val topTrackList: List<Track>): RecyclerView.Adapter<TrackRankingListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init{
            val test = itemView.findViewById<TextView>(R.id.azerty)

            itemView.setOnClickListener{
                val position: Int = adapterPosition
                val context = itemView.context
                val intent = Intent(context, AlbumDetails::class.java).apply {
                    putExtra("NUMBER", position)
                    putExtra("test", test.text)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.track_ranking_item_cell, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        println("-----------------------------------------------------")
        println(topTrackList[position].idTrack)
        println("-----------------------------------------------------")
        holder.itemView.azerty.text = topTrackList[position].idTrack
    }

    override fun getItemCount(): Int {
        return topTrackList.size
    }


}

