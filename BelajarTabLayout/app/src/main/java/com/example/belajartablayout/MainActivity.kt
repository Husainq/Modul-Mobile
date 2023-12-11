package com.example.belajartablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Mms.Draft
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.belajartablayout.Fragment.InboxFragment
import com.example.belajartablayout.Fragment.DraftFragment
import com.example.belajartablayout.Fragment.SentFragment
import com.example.belajartablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = binding.toolbarAwal
        setSupportActionBar(toolbar)
        supportActionBar!!.title = ""

        val tabLayout: TabLayout = binding.tabLayout
        val viewPager: ViewPager = binding.viewPager
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        viewPagerAdapter.tambahFragment(InboxFragment(), "Inbox")
        viewPagerAdapter.tambahFragment(DraftFragment(), "Draft")
        viewPagerAdapter.tambahFragment(SentFragment(), "Sent")

        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

    internal class ViewPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(
        fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

        private val fragments : ArrayList<Fragment>
        private val juduls : ArrayList<String>

        init{
            fragments = ArrayList()
            juduls = ArrayList()
        }

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        fun tambahFragment(fragment: Fragment, judul: String){
            fragments.add(fragment)
            juduls.add(judul)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return juduls[position]
        }
    }

}