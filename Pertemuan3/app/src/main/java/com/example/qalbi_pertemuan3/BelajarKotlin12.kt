package com.example.qalbi_pertemuan3
// User Defined-Function
fun main(){
    namaku()
    contohReturn("Budi",12)
    println("Ini hasil dari function jumlah : ${jumlah(5, 10, 15, 20)}")
}

fun namaku(){
    println("Muhammad Qalbi Husaini")
}

fun contohReturn(nama: String, umur:Int){
    println("Halo, namaku $nama. Umurku $umur tahun")
}

fun jumlah(vararg angka: Int): Int{
    var hasilJumlah = 0
    angka.forEach { nilai -> hasilJumlah += nilai }

    return hasilJumlah
}