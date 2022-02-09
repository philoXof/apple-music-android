package com.example.kelyan_bervin.apple_music_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kelyan_bervin.apple_music_android.api.NetworkManager
import kotlinx.android.synthetic.main.album_details.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AlbumDetails() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.album_details,
            container,
            false
        )



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //définir ce qui sera affiché dans le TextView de album_details.xml

        /*
        val albumName = arguments?.getString("albumName")
        val age = arguments?.getInt("age")

        title.text = albumName
        */


        GlobalScope.launch(Dispatchers.Default) {
            val response = NetworkManager.getAlbum("2115888")

            withContext(Dispatchers.Main) {
                album_title.text = response.album.strAlbum
            }
        }


    }
}