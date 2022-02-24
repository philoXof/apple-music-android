package com.example.kelyan_bervin.apple_music_android.ranking.album_ranking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.*
import com.example.kelyan_bervin.apple_music_android.AlbumDetails
import com.example.kelyan_bervin.apple_music_android.MainActivity
import com.example.kelyan_bervin.apple_music_android.R
import com.example.kelyan_bervin.apple_music_android.api.NetworkManager
import com.example.kelyan_bervin.apple_music_android.data_class.Album
import kotlinx.android.synthetic.main.album_ranking_list.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException


class AlbumRankingList : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.album_ranking_list, container, false
        )
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val albumList = arrayListOf<Album>()

        try {
            GlobalScope.launch(Dispatchers.Default) {
                val response = NetworkManager.getTopTenAlbum()

                withContext(Dispatchers.Main) {
                    albumList.addAll(response.album)

                    main_list.run {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = AlbumRankingListAdapter(albumList, object: OnItemClickedListener {
                            override fun onItemClicked(idAlbum: String) {
                                Toast.makeText(context, idAlbum, Toast.LENGTH_SHORT).show()


                                findNavController().navigate(
                                    AlbumRankingListDirections.actionAlbumRankingListToAlbumDetails(
                                        idAlbumParam = idAlbum
                                    )
                                )

                                /*val arguments = Bundle()
                                arguments.putString("idAlbumParam", idAlbum)
                                val fragment = AlbumDetails()
                                fragment.arguments = arguments

                                 */

                                //val bundle = bundleOf(Pair("idAlbum", String))
                                //view.findNavController().navigate(R.id.albumDetails)

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

        } catch (e: IOException){
            println(e)
        }






    }

    
}

