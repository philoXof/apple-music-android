package com.example.kelyan_bervin.apple_music_android.ranking.album_ranking

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.*
import com.example.kelyan_bervin.apple_music_android.R
import com.example.kelyan_bervin.apple_music_android.api.NetworkManager
import com.example.kelyan_bervin.apple_music_android.data_class.Album
import com.example.kelyan_bervin.apple_music_android.details.album.AlbumDetails
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

        albumRankingListProgressBar.visibility = View.VISIBLE


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

                                /*val navController = Navigation.findNavController(
                                    activity!!,
                                    R.id.main_list
                                )

                                navController.navigate(
                                    AlbumRankingListDirections.actionAlbumRankingListToAlbumDetails(
                                        idAlbumParam = idAlbum
                                    )
                                )*/


                                //NavHostFragment.findNavController(AlbumDetails())

                                /*lifecycleScope.launchWhenResumed {
                                    findNavController().navigate(R.id.action_albumRankingList_to_albumDetails)
                                }*/


                                /*val navHostFragment = findNavController() as NavHostFragment
                                val navController = navHostFragment.navController
                                 */


                                //val intent: Intent = Intent()
                                findNavController().navigate(
                                    //intent.putExtra("idAlbum", idAlbum)
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
                        albumRankingListProgressBar.visibility = View.GONE
                    }
                }

            }

        } catch (e: IOException){
            println(e)
        }






    }

    
}

