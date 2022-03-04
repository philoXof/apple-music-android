package com.example.kelyan_bervin.apple_music_android

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.kelyan_bervin.apple_music_android.details.album.AlbumDetails
import com.example.kelyan_bervin.apple_music_android.details.artist.ArtistDetails
import com.example.kelyan_bervin.apple_music_android.favorites.Favorites
import com.example.kelyan_bervin.apple_music_android.ranking.MyAdapter
import com.example.kelyan_bervin.apple_music_android.ranking.Ranking
import com.example.kelyan_bervin.apple_music_android.ranking.album_ranking.AlbumRankingList
import com.example.kelyan_bervin.apple_music_android.ranking.track_ranking.TrackRankingList
import com.example.kelyan_bervin.apple_music_android.search.Search
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        //code pour tester les écrans individuellement
/*
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, Favorites())
            .commitAllowingStateLoss()
*/

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val viewPager = findViewById<ViewPager>(R.id.tab_viewpager)
        setupMainViewPager(viewPager)

        val tabLayout = findViewById<TabLayout>(R.id.main_tab_tablayout)
        tabLayout.setupWithViewPager(viewPager)




    }


    private fun setupMainViewPager(viewpager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(Ranking(), "classement")
        adapter.addFragment(Search(), "Recherche")
        adapter.addFragment(Favorites(), "Favoris")

        viewpager.adapter = adapter
    }


    /* TODO: Mettre dans un fichier */
    class ViewPagerAdapter(supportFragmentManager: FragmentManager) :
        FragmentPagerAdapter(supportFragmentManager) {

        var fragmentList: ArrayList<Fragment> = ArrayList()
        var fragmentTitleList: ArrayList<String> = ArrayList()


        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        @Nullable
        override fun getPageTitle(position: Int): CharSequence {
            return fragmentTitleList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            fragmentList.add(fragment)
            fragmentTitleList.add(title)
        }
    }

}
