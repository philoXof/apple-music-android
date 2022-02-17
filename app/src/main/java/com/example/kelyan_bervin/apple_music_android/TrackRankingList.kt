package com.example.kelyan_bervin.apple_music_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
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

        var topTrackList = listOf<Track>()

        GlobalScope.launch(Dispatchers.Default) {
            val response = NetworkManager.getTopTrack()

            withContext(Dispatchers.Main) {
                topTrackList = response.tracks
            }
        }

        recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = TrackRankingListAdapter(topTrackList)
        }
    }


}