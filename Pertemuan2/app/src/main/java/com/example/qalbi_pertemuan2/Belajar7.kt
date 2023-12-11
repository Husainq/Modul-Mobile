package com.example.qalbi_pertemuan2

fun main(){
    //Looping - For Loop
    for (nilai in 15..25){
        print(" $nilai")
    }
    println()

    val kampusKu = arrayOf("Kampus", "Politeknik", "Caltex", "Riau")
    for(kampus in kampusKu) {
        println(kampus)
    }
    for (n in kampusKu.indices){
        println("Isi array [$n] = ${kampusKu[n]}")
    }

    val cobaArray = arrayOf(2, 4, 5, 8, 11)
    for((idx, nilai) in cobaArray.withIndex()){
        println("Isi pada index $idx adalah : $nilai")
        if (nilai % 2 == 0){
            println("Bilangan Genap : $nilai")
        } else{
            println("Bilangan Ganjil : $nilai")
        }
    }
}