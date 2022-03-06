package com.example.kelyan_bervin.apple_music_android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.kelyan_bervin.apple_music_android.favorites.Favorites
import com.example.kelyan_bervin.apple_music_android.ranking.Ranking
import com.example.kelyan_bervin.apple_music_android.search.Search
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        //code pour tester les écrans individuellement

        //setContentView(R.layout.ranking) //Classement
        //setContentView(R.layout.favorites) //Favoris
        //setContentView(R.layout.search) //Recherche
        //setContentView(R.layout.album_details) //Detail d'un album
        //setContentView(R.layout.artist_details) //Detail d'un artiste

/*
        supportFragmentManager.beginTransaction()
            //.replace(android.R.id.content, Ranking()) //Classement
            //.replace(android.R.id.content, Favorites()) //Favoris
            //.replace(android.R.id.content, Search()) //Recherche
            //.replace(android.R.id.content, AlbumDetails()) //Detail d'un album
            //.replace(android.R.id.content, ArtistDetails()) //Detail d'un artiste
            //.commitAllowingStateLoss()
*/


        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val viewPager = findViewById<ViewPager>(R.id.tab_viewpager)
        setupMainViewPager(viewPager)

        val tabLayout = findViewById<TabLayout>(R.id.main_tab_tablayout)
        tabLayout.setupWithViewPager(viewPager)

    }


    private fun setupMainViewPager(viewpager: ViewPager) {
        val adapter = MainViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(Ranking(), "classement")
        adapter.addFragment(Search(), "Recherche")
        adapter.addFragment(Favorites(), "Favoris")

        viewpager.adapter = adapter
    }

}
