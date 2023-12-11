package com.example.belajarrecyclerview

import android.app.DownloadManager.Request
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.belajarrecyclerview.databinding.DetilDosenBinding

class DetilDosen : AppCompatActivity() {
    private lateinit var binding: DetilDosenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetilDosenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        if(intent.hasExtra("namanya")){
            val nama: String = this.intent.getStringExtra("namanya").toString()
            val foto: String = this.intent.getStringExtra("fotonya").toString()
            setDetil(foto, nama)
        }
    }
    fun setDetil(foto: String, nama: String){
        val requestOp = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        binding.namaDetilDosen.text = nama
        Glide.with(this)
            .load(foto)
            .apply(requestOp)
            .centerCrop()
            .into(binding.fotoDetil)
    }
}