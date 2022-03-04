package com.example.kelyan_bervin.apple_music_android

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.kelyan_bervin.apple_music_android.details.album.AlbumDetails
import com.example.kelyan_bervin.apple_music_android.details.artist.ArtistDetails
import com.example.kelyan_bervin.apple_music_android.favorites.Favorites
import com.example.kelyan_bervin.apple_music_android.ranking.Ranking
import com.example.kelyan_bervin.apple_music_android.search.Search
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


//TODO :
// * Mettre toute la logique des onglets "Albums" et "Titres" dans les fichiers Ranking et ranking.xml : ko
// **
// * Trouver le moyen de passer la classe Ranking en Fragment
//                          (lorque l'on passe Ranking en type Fragment certaines fonctions ne sont plus disponible)
// **
// * Mettre en place la logique des onglets "Classement", "Recherche" et "Favoris" dans le main


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.artist_details)

        //code du prof pour utiliser le fragment AlbumDetail()

        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, ArtistDetails())
            .commitAllowingStateLoss()


        /*GlobalScope.launch(Dispatchers.Default) {
            withContext(Dispatchers.Main) {
                val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
                val viewPager = findViewById<ViewPager>(R.id.tab_viewpager)

                //val tabLayout = findViewById<TabLayout>(R.id.tab_tablayout)

                setSupportActionBar(toolbar)
                //setupViewPager(viewPager)
                //tabLayout.setupWithViewPager(viewPager)



                val mainTabLayout = findViewById<TabLayout>(R.id.main_tab_tablayout)
                setupMainViewPager(viewPager)
                mainTabLayout.setupWithViewPager(viewPager)
            }

        }*/



        /*runOnUiThread {
            val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
            val viewPager = findViewById<ViewPager>(R.id.tab_viewpager)

            //val tabLayout = findViewById<TabLayout>(R.id.tab_tablayout)

            setSupportActionBar(toolbar)
            //setupViewPager(viewPager)
            //tabLayout.setupWithViewPager(viewPager)



            val mainTabLayout = findViewById<TabLayout>(R.id.main_tab_tablayout)
            setupMainViewPager(viewPager)
            mainTabLayout.setupWithViewPager(viewPager)
        }*/

        /*Thread {
            // performing some dummy time taking operation

            // try to touch View of UI thread
            this@MainActivity.runOnUiThread {
                val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
                val viewPager = findViewById<ViewPager>(R.id.tab_viewpager)

                //val tabLayout = findViewById<TabLayout>(R.id.tab_tablayout)

                setSupportActionBar(toolbar)
                //setupViewPager(viewPager)
                //tabLayout.setupWithViewPager(viewPager)


                val mainTabLayout = findViewById<TabLayout>(R.id.main_tab_tablayout)
                setupMainViewPager(viewPager)
                mainTabLayout.setupWithViewPager(viewPager)
            }
        }.start()*/


    }


     /*fun setupViewPager(viewpager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(TrackRankingList(), "Titres")
        adapter.addFragment(AlbumRankingList(), "Albums")

        viewpager.adapter = adapter
    }*/

    private fun setupMainViewPager(viewpager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)


        adapter.addFragment( Ranking(), "classement")
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

        fun addFragment(fragment: Fragment?, title: String) {

            if (fragment != null) fragmentList.add(fragment)

            fragmentTitleList.add(title)
        }
    }







}
