package com.welooky.welook.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.welooky.welook.R
import com.welooky.welook.support.BaseActivity
import org.jetbrains.anko.find


class MainActivity : BaseActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_micro_look -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_discovery -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_mine -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        val viewPager = find<ViewPager2>(R.id.viewpager)
        viewPager.offscreenPageLimit = 1
        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun getItemCount(): Int {
                return 3
            }
        }

    }
}
