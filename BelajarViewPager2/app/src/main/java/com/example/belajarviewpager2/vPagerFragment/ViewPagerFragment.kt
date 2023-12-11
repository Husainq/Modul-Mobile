package com.example.belajarviewpager2.vPagerFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.belajarviewpager2.R
import com.example.belajarviewpager2.databinding.FragmentViewPagerBinding
import com.example.belajarviewpager2.vPagerFragment.screen.HalamanKedua
import com.example.belajarviewpager2.vPagerFragment.screen.HalamanKetiga
import com.example.belajarviewpager2.vPagerFragment.screen.HalamanPertama

class ViewPagerFragment : Fragment() {
    lateinit var binding: FragmentViewPagerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_pager,
            container, false)
        binding = FragmentViewPagerBinding.bind(view)
        val fragmentList = arrayListOf(
            HalamanPertama(),
            HalamanKedua(),
            HalamanKetiga()
        )
        val adapter = ViewPagerAdapter(fragmentList,
            requireActivity().supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter
        return view
    }

}
