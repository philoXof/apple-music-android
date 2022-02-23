package com.example.kelyan_bervin.apple_music_android.ranking.track_ranking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kelyan_bervin.apple_music_android.R
import com.example.kelyan_bervin.apple_music_android.data_class.Track
import com.example.kelyan_bervin.apple_music_android.api.NetworkManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.track_ranking_item_cell.*
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

                topTrackList.addAll(response.tracks)

                track_ranking_list.run {
                    layoutManager = LinearLayoutManager(activity)
                    adapter = TrackRankingListAdapter(topTrackList, object: OnTrackClickedListener{
                        override fun onItemClicked(idTrack: String) {
                            Toast.makeText(context, idTrack, Toast.LENGTH_SHORT).show()

                            findNavController().navigate(
                                TrackRankingListDirections.actionTrackRankingListToArtistDetails(
                                    idTrackParam = idTrack
                                )
                            )

                        }
                    })
                    addItemDecoration(
                        DividerItemDecoration(
                            requireContext(), DividerItemDecoration.VERTICAL
                        )
                    )
                }
            }
        }

    }


}