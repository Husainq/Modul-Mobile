package com.example.belajarrecyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.belajarrecyclerview.databinding.LayoutListDosenBinding

class DosenRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items : List<ListObjDosen> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DosenViewHolder {
        val binding = LayoutListDosenBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return DosenViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DosenViewHolder -> {
                holder.bind(items.get(position))
                holder.klik.setOnClickListener {
                    holder.kalau_diklik(items.get(position))
                }
            }
        }
    }

    fun submitList(listDosen: List<ListObjDosen>) {
        items = listDosen
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class DosenViewHolder constructor(val binding: LayoutListDosenBinding): RecyclerView.ViewHolder(binding.root) {
        val foto_dosen: ImageView = binding.gambarDosen
        val nama_dosen: TextView = binding.namaDosen
        val kom_dosen: TextView = binding.kompetensiDosen
        val nip_dosen: TextView = binding.nipDosen
        val mk_dosen: TextView = binding.mkDosen
        val ruangan_dosen: TextView = binding.ruanganDosen
        var klik: RelativeLayout = binding.rlKlik

        fun bind(listObjDosen: ListObjDosen) {
            nama_dosen.setText(listObjDosen.nama)
            kom_dosen.setText(listObjDosen.kompotensi)
            nip_dosen.setText(listObjDosen.nip)
            mk_dosen.setText(listObjDosen.matakuliah)
            ruangan_dosen.setText(listObjDosen.ruangan)


            val requestOp = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOp)
                .load(listObjDosen.gambar)
                .into(foto_dosen)
        }

        fun kalau_diklik(get: ListObjDosen){
            Toast.makeText(itemView.context, "Kamu memilih : ${get.nama}",
                Toast.LENGTH_SHORT)
                .show()

            val intent = Intent(itemView.context, DetilDosen::class.java)
            intent.putExtra("namanya", get.nama)
            intent.putExtra("kompentensinya", get.kompotensi)
            intent.putExtra("fotonya", get.gambar)
            intent.putExtra("nipnya", get.nip)
            intent.putExtra("matakuliahnya", get.matakuliah)
            intent.putExtra("ruangannya", get.ruangan)
            itemView.context.startActivity(intent)
        }
    }
}