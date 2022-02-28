package com.example.kelyan_bervin.apple_music_android.ranking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.kelyan_bervin.apple_music_android.MainActivity
import com.example.kelyan_bervin.apple_music_android.R
import com.google.android.material.tabs.TabLayout

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

        val viewPager = view.findViewById<ViewPager>(R.id.r_tab_viewpager)
        val tabLayout = view.findViewById<TabLayout>(R.id.r_tablayout)

        //val pViewPager = view.findViewById<ViewPager>(R.id.r_tab_viewpager)
        //val pagerAdapters = RankingAdapter(supportFragmentManager)


        val mainActivity = MainActivity()
        mainActivity.setupViewPager(viewPager)

        //setSupportActionBar(toolbar)
        //setupViewPager(viewPager)
        tabLayout.setupWithViewPager(viewPager)
    }




    /*private fun setupViewPager(viewpager: ViewPager) {
        val adapter = ViewPagerAdapter()

        adapter.addFragment(TrackRankingList(), "Titres")
        adapter.addFragment(AlbumRankingList(), "Albums")

        viewpager.adapter = adapter
    }*/

/*
    class ViewPagerAdapter(supportFragmentManager: FragmentManager) :
        FragmentPagerAdapter(supportFragmentManager) {

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


        fun addFragment(fragment: Fragment, title: String) {
            fragmentList1.add(fragment)
            fragmentTitleList1.add(title)
        }
    }
*/

}

