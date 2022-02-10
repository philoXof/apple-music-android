package com.example.kelyan_bervin.apple_music_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //code du prof pour utiliser le fragment AlbumDetail()

        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, AlbumDetails())
            .commitAllowingStateLoss()

    }
}