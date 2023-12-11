package com.example.belajarviewpager2.vPagerFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.belajarviewpager2.R

/**
 * A simple [Fragment] subclass.
 * Use the [ViewPagerAdapter.newInstance] factory method to
 * create an instance of this fragment.
 */

class ViewPagerAdapter (
    list: ArrayList<Fragment>,
    manager: FragmentManager,
    lifecycle: Lifecycle) :
    FragmentStateAdapter(manager, lifecycle) {

    private val fragmentList = list
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}