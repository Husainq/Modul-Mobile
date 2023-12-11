package com.example.qalbi_pertemuan3

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.qalbi_pertemuan3.databinding.ActivityFrameLayoutBinding

class FrameLayout : AppCompatActivity() {
    private lateinit var binding : ActivityFrameLayoutBinding

    override fun onCreate(savedInstanceStats: Bundle?){
        super.onCreate(savedInstanceStats)
        binding = ActivityFrameLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClick(v: View?){
        binding.btnKlik.visibility = View.GONE
        binding.txtTombol.visibility = View.VISIBLE
    }
}