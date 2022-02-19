package com.example.kelyan_bervin.apple_music_android

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.kelyan_bervin.apple_music_android.ranking.album_ranking.AlbumRankingList
import com.example.kelyan_bervin.apple_music_android.ranking.track_ranking.TrackRankingList
import com.google.android.material.tabs.TabLayout

class Ranking: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.ranking)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        val viewPager = findViewById<ViewPager>(R.id.tab_viewpager)
        val tabLayout = findViewById<TabLayout>(R.id.tab_tablayout)

        setSupportActionBar(toolbar)
        setupViewPager(viewPager)
        tabLayout.setupWithViewPager(viewPager)
    }

    private fun setupViewPager(viewpager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(TrackRankingList(), "Titres")
        adapter.addFragment(AlbumRankingList(), "Albums")

        viewpager.adapter = adapter
    }


    class ViewPagerAdapter(supportFragmentManager: FragmentManager) :
        FragmentPagerAdapter(supportFragmentManager) {

        // objects of arraylist. One is of Fragment type and
        // another one is of String type.*/
        var fragmentList1: ArrayList<Fragment> = ArrayList()
        var fragmentTitleList1: ArrayList<String> = ArrayList()


        override fun getItem(position: Int): Fragment {
            return fragmentList1[position]
        }


        @Nullable
        override fun getPageTitle(position: Int): CharSequence {
            return fragmentTitleList1.get(position)
        }

        override fun getCount(): Int {
            return fragmentList1.size
        }

        // this function adds the fragment and title in 2 separate arraylist.
        fun addFragment(fragment: Fragment, title: String) {
            fragmentList1.add(fragment)
            fragmentTitleList1.add(title)
        }
    }


}