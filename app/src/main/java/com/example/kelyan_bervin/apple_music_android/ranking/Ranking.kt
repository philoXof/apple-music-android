package com.example.kelyan_bervin.apple_music_android.ranking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.kelyan_bervin.apple_music_android.R
import com.example.kelyan_bervin.apple_music_android.ranking.album_ranking.AlbumRankingList
import com.example.kelyan_bervin.apple_music_android.ranking.track_ranking.TrackRankingList
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Ranking: Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.ranking,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = view.findViewById<ViewPager2>(R.id.r_tab_viewpager)
        val tabLayout = view.findViewById<TabLayout>(R.id.r_tablayout)


        tabLayout.addTab(tabLayout.newTab())
        tabLayout.addTab(tabLayout.newTab())

        val adapter = MyAdapter(this, viewPager, tabLayout.tabCount)

        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager){tab, position ->
            when(position){
                0 -> {
                    tab.text = "Titres"
                }
                1 -> {
                    tab.text = "Albums"
                }
            }

        }.attach()

    }

}


class MyAdapter(fm: Fragment, viewPager2: ViewPager2, var totalTabs: Int) : FragmentStateAdapter(fm) {

    override fun getItemCount(): Int {
        return totalTabs
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                return TrackRankingList()
            }
            1 -> {
                return  AlbumRankingList()
            }
            else -> throw Exception("???")
        }
    }
}

