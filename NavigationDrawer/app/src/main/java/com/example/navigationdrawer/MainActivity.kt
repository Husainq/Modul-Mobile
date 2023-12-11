package com.example.navigationdrawer

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.navigationdrawer.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var inboxFragment: HalamanInbox
    lateinit var draftFragment: HalamanDraft
    lateinit var sendFragment: HalamanSend
    lateinit var settingFragment: HalamanSetting
    lateinit var helpFragment: HalamanHelp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toggle = ActionBarDrawerToggle(this, binding.drawerLayout,R.string.open, R.string.closen)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.napView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.inbox -> {
                inboxFragment = HalamanInbox()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, inboxFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(applicationContext,"Ini halaman Inbox", Toast.LENGTH_SHORT)
                    .show()
            }
            R.id.draft -> {
                draftFragment = HalamanDraft()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, draftFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(applicationContext,"Ini halaman Draft", Toast.LENGTH_SHORT)
                    .show()
            }
            R.id.send -> {
                sendFragment = HalamanSend()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, sendFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(applicationContext,"Ini halaman Send", Toast.LENGTH_SHORT)
                    .show()
            }
            R.id.setting -> {
                settingFragment = HalamanSetting()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, settingFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(applicationContext,"Ini halaman Setting", Toast.LENGTH_SHORT)
                    .show()
            }
            R.id.help -> {
                helpFragment = HalamanHelp()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, helpFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(applicationContext,"Ini halaman Help", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        binding.drawerLayout.closeDrawers()
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}