package com.example.belajarrecyclerview

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.belajarrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var dosenAdapter: DosenRecyclerAdapter
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        tambahDataSet()
    }

    private fun tambahDataSet() {
        val data = SumberData.buatSetData()
        dosenAdapter.submitList(data)
    }

    private fun initRecyclerView(){
        binding.recylerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val spacingAtas = DekorasiSpasiGambar(20)
            addItemDecoration(spacingAtas)
            dosenAdapter = DosenRecyclerAdapter()
            adapter = dosenAdapter
        }
    }
}