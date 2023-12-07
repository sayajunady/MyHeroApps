package com.kopikode.myheroapps

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kopikode.myheroapps.fragment.AccountFragment
import com.kopikode.myheroapps.fragment.ExploreFragment
import com.kopikode.myheroapps.fragment.HomeFragment
import com.kopikode.myheroapps.fragment.LibraryFragment
import com.kopikode.myheroapps.fragment.SubscriptionFragment

class MainActivity : AppCompatActivity() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)


        val homeFragment = HomeFragment()
        val exploreFragment = ExploreFragment()
        val subscriptionFragment = SubscriptionFragment()
        val libraryFragment = LibraryFragment()
        val accountFragment = AccountFragment()

        makeCurrentFragment (homeFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> makeCurrentFragment(homeFragment)
                R.id.menu_explore -> makeCurrentFragment(exploreFragment)
                R.id.menu_subscription -> makeCurrentFragment(subscriptionFragment)
                R.id.menu_library-> makeCurrentFragment(libraryFragment)
                R.id.menu_account-> makeCurrentFragment(accountFragment)
            }

            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, fragment)
            commit()
        }

    }
}