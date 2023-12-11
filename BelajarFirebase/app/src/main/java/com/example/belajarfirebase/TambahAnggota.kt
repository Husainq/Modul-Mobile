package com.example.belajarfirebase

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import com.example.belajarfirebase.databinding.ActivityTambahDetilBinding

class TambahAnggota : AppCompatActivity() {
    private lateinit var tvJudul: TextView
    private lateinit var edtAlamat: EditText
    private lateinit var edtKodePos: EditText
    private lateinit var btnSimpan: Button
    private lateinit var lvTambahDetil: ListView
    private lateinit var detilList: MutableList<DetilAnggota>
    private lateinit var ref: DatabaseReference

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_NAMA = "extra_nama"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_detil)

        tvJudul = findViewById(R.id.txt_judul_detil)
        edtAlamat = findViewById(R.id.edt_alamat)
        edtKodePos = findViewById(R.id.edt_kodePos)
        btnSimpan = findViewById(R.id.btn_tambahDetil)
        lvTambahDetil = findViewById(R.id.lv_tambahDetil)
        val id = intent.getStringExtra(EXTRA_ID)
        val nama = intent.getStringExtra(EXTRA_NAMA)

        detilList = mutableListOf()
        ref = FirebaseDatabase.getInstance().getReference("detil anggota")
            .child(id!!)

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    detilList.clear()
                    for (a in snapshot.children) {
                        val detil = a.getValue(DetilAnggota::class.java)
                        if (detil != null){
                            detilList.add(detil)
                        }
                    }

                    val adapter = DetilAnggotaAdapter( this@TambahAnggota,
                        R.layout.activity_item_detil, detilList)
                    lvTambahDetil.adapter = adapter

                    println("Output : " +detilList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        btnSimpan.setOnClickListener {
            simpanDetil()
        }
    }

    private fun simpanDetil(){
        val alamat = edtAlamat.text.toString().trim()
        val kodePos = edtKodePos.text.toString()

        if (alamat.isEmpty()){
            edtAlamat.error = "Isi alamat terlebih dahulu"
            return
        }
        if (kodePos.isEmpty()){
            edtKodePos.error = "Isi kode pos terlebih dahulu"
            return
        }
        val detilId = ref.push().key

        val detil = DetilAnggota(detilId!!, alamat, kodePos)

        ref.child(detilId).setValue(detil).addOnCompleteListener{
            Toast.makeText(applicationContext, "Informasi tambahan berhasil ditambahkan",
                Toast.LENGTH_SHORT)
                .show()
        }
    }
}