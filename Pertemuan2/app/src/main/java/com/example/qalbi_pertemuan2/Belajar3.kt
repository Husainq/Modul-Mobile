package com.example.qalbi_pertemuan2

fun main(){
    //Collection
    val kataMutable: MutableList<String> = mutableListOf("Hai", "Halo", "Aloha")
    println("List yang menggunakan Mutable" + kataMutable)

    kataMutable.add("Hi")
    kataMutable.removeAt(0)

    println("List mutable setelah ditambahkan " + kataMutable)
    println("List mutable setelah dihapus " + kataMutable)

    kataMutable.shuffle()
    println("List mutable setelah suffle " + kataMutable)

    val kataImmunitable: List<String> = kataMutable
    println(kataMutable)

    println("Kata pertama dari mutable : " + kataImmunitable.first())

    val cobaSet = setOf("Belajar", "Pemrograman", "Mobile")
    println("Set : " + cobaSet)

    val cobaMap = mapOf(1 to "Shumaya", 2 to "Resty", 3 to "Ramadhani")
    println("Map : " + cobaMap.values)
}