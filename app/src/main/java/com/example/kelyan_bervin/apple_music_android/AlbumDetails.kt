package com.example.kelyan_bervin.apple_music_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.app.Person.fromBundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.album_details.*

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


        val title: TextView = view.findViewById(R.id.album_title)
        title.text = AlbumDetailsArgs.fromBundle(requireArguments()).album




    }
}