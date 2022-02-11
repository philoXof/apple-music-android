package com.example.kelyan_bervin.apple_music_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kelyan_bervin.apple_music_android.api.NetworkManager
import kotlinx.android.synthetic.main.album_details.*
import kotlinx.coroutines.*
import java.io.IOException

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

        try {
            GlobalScope.launch(Dispatchers.Default) {

                val response = NetworkManager.getAlbum("2115888")
                //val response = NetworkManager.getProductTest("5000159484695") //test

                withContext(Dispatchers.Main) {
                    album_title.text = response.album.strAlbum
                    //album_title.text = response.product.name //test
                }
            }
        } catch (e: IOException){
            println(e)
        }


    }
}