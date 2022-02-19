package com.example.kelyan_bervin.apple_music_android.ranking.track_ranking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kelyan_bervin.apple_music_android.R
import com.example.kelyan_bervin.apple_music_android.data_class.Track
import com.example.kelyan_bervin.apple_music_android.api.NetworkManager
import kotlinx.android.synthetic.main.track_ranking_list.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TrackRankingList: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.track_ranking_list, container, false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val topTrackList = arrayListOf<Track>()

        GlobalScope.launch(Dispatchers.Default) {
            val response = NetworkManager.getTopTrack()

            withContext(Dispatchers.Main) {
                //topTrackList.addAll(response.tracks)
            }
        }

        val track1 = Track("1", "e", "track1", "strTrack", "e", "strArtist", "e")
        val track2 = Track("2", "e", "track2", "strTrack", "e", "strArtist", "e")
        val track3 = Track("3", "e", "track3", "strTrack", "e", "strArtist", "e")
        val track4 = Track("4", "e", "track4", "strTrack", "e", "strArtist", "e")
        val track5 = Track("5", "e", "track5", "strTrack", "e", "strArtist", "e")

        topTrackList.add(track1)
        topTrackList.add( track2)
        topTrackList.add(track3)
        topTrackList.add(track4)
        topTrackList.add(track5)
        

        track_ranking_list.run {
            layoutManager = LinearLayoutManager(activity)
            adapter = TrackRankingListAdapter(topTrackList)
        }
    }


}