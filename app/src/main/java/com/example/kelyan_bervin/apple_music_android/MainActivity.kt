package com.example.kelyan_bervin.apple_music_android

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.kelyan_bervin.apple_music_android.bdd.DatabaseManager
import com.example.kelyan_bervin.apple_music_android.data_class.Album
import com.example.kelyan_bervin.apple_music_android.ranking.album_ranking.AlbumRankingList
import com.example.kelyan_bervin.apple_music_android.ranking.track_ranking.TrackRankingList
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


//TODO :
// * Mettre toute la logique des onglets "Albums" et "Titres" dans les fichiers Ranking et ranking.xml : ok
// **
// * Trouver le moyen de passer la classe Ranking en Fragment
//                          (lorque l'on passe Ranking en type Fragment certaines fonctions ne sont plus disponible)
// **
// * Mettre en place la logique des onglets "Classement", "Recherche" et "Favoris" dans le main


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.artiste_details)

        //code du prof pour utiliser le fragment AlbumDetail()

        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, ArtistDetails())
            .commitAllowingStateLoss()


        GlobalScope.launch {
            val databaseManager = DatabaseManager(this@MainActivity)
            databaseManager.addAlbum(
                Album("test", "test", "test", "test",
                    "test", "test", "test", "test")
            )

            val listAlbumTest = databaseManager.findAllAlbum()
            print(listAlbumTest.size)
        }


/*
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        val viewPager = findViewById<ViewPager>(R.id.tab_viewpager)
        val tabLayout = findViewById<TabLayout>(R.id.tab_tablayout)

        setSupportActionBar(toolbar)
        setupViewPager(viewPager)
        tabLayout.setupWithViewPager(viewPager)
*/

    }


    private fun setupViewPager(viewpager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(TrackRankingList(), "Titres")
        adapter.addFragment(AlbumRankingList(), "Albums")

        viewpager.adapter = adapter
    }


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

        // this function adds the fragment and title in 2 separate arraylist.
        fun addFragment(fragment: Fragment, title: String) {
            fragmentList1.add(fragment)
            fragmentTitleList1.add(title)
        }
    }



}
