package com.example.kelyan_bervin.apple_music_android

import android.os.Bundle
import android.service.notification.NotificationListenerService
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager.widget.ViewPager
import com.example.kelyan_bervin.apple_music_android.details.album.AlbumDetails
import com.example.kelyan_bervin.apple_music_android.details.artist.ArtistDetails
import com.example.kelyan_bervin.apple_music_android.favorites.Favorites
import com.example.kelyan_bervin.apple_music_android.ranking.Ranking
import com.example.kelyan_bervin.apple_music_android.ranking.album_ranking.AlbumRankingList
import com.example.kelyan_bervin.apple_music_android.ranking.track_ranking.TrackRankingList
import com.example.kelyan_bervin.apple_music_android.search.Search
import com.google.android.material.tabs.TabLayout


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

        setContentView(R.layout.ranking)

        //code du prof pour utiliser le fragment AlbumDetail()
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, Ranking())
            .commitAllowingStateLoss()


/*
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        val viewPager = findViewById<ViewPager>(R.id.tab_viewpager)

        val tabLayout = findViewById<TabLayout>(R.id.tab_tablayout)

        setSupportActionBar(toolbar)
        setupViewPager(viewPager)
        tabLayout.setupWithViewPager(viewPager)
*/

        /*
        val mainTabLayout = findViewById<TabLayout>(R.id.main_tab_tablayout)
        setupMainViewPager(viewPager)
        mainTabLayout.setupWithViewPager(viewPager)
        */


    }

/*
     fun setupViewPager(viewpager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(null, TrackRankingList(), "Titres")
        adapter.addFragment(null, AlbumRankingList(), "Albums")

        viewpager.adapter = adapter
    }

    fun setupMainViewPager(viewpager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)


        adapter.addFragment(MainActivity(), null, "classement")
        adapter.addFragment(null, Search(), "Recherche")
        adapter.addFragment(null, Favorites(), "Favoris")

        viewpager.adapter = adapter
    }



    /* TODO: Mettre dans un fichier */
    class ViewPagerAdapter(supportFragmentManager: FragmentManager) :
        FragmentPagerAdapter(supportFragmentManager) {

        var mainActivityList: ArrayList<MainActivity> = ArrayList()
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

        fun addFragment(mainActivity: MainActivity?, fragment: Fragment?, title: String) {
            if (mainActivity != null) mainActivityList.add(mainActivity)

            if (fragment != null) fragmentList.add(fragment)

            fragmentTitleList.add(title)
        }
    }

 */





}
