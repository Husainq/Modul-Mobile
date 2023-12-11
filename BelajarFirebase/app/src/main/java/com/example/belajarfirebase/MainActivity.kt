package com.example.belajarfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.database.*
import com.example.belajarfirebase.databinding. ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var ref: DatabaseReference
    private lateinit var anggotaList: MutableList<Anggota>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ref= FirebaseDatabase.getInstance().getReference( "anggota")

        binding.btnSimpan.setOnClickListener (this)
        anggotaList = mutableListOf()

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange (snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    anggotaList.clear()
                    for (a in snapshot.children) {
                        val anggota = a.getValue(Anggota::class.java)
                        if (anggota != null) {
                            anggotaList.add(anggota)
                        }
                    }

                    val adapter = AnggotaAdapter(
                        this@MainActivity,
                        R.layout.activity_item_anggota, anggotaList
                    )
                    binding.lvHasil.adapter = adapter

                    println("Output: " + anggotaList)
                }
            }

            override fun onCancelled (error: DatabaseError) {
                TODO( "Not yet implemented")
            }
        })
        binding.lvHasil.setOnItemClickListener { parent, view, position, id ->
            val anggota = anggotaList.get(position)
            val intent = Intent(this, TambahAnggota ::class.java)
            intent.putExtra(TambahAnggota.EXTRA_ID, anggota.id)
            intent.putExtra(TambahAnggota.EXTRA_NAMA, anggota.nama)
            startActivity(intent)
        }
    }
    override fun onClick(v: View?) {
        simpanData()
    }

    private fun simpanData() {
        val nama = binding.edtNama.text.toString().trim()
        val hp = binding.edtNoHp.text.toString()
        val usia = binding.edtUsia.text.toString()
        val alamat = binding.edtKota.text.toString().trim()

        if (nama.isEmpty() or hp.isEmpty() or usia.isEmpty() or alamat.isEmpty()) {
            Toast.makeText(this, "Isi data secara lengkap tidak boleh kosong",
                Toast.LENGTH_SHORT)
                .show()
            return
        }

        val anggotaId = ref.push().key
        val anggota = Anggota (anggotaId!!, nama, alamat, usia, hp)

        ref.child(anggotaId).setValue(anggota).addOnCompleteListener{
            Toast.makeText(applicationContext, "Data berhasil ditambahkan", Toast.LENGTH_SHORT)
                .show()
        }
    }
}