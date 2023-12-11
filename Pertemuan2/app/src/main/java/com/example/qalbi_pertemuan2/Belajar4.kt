package com.example.qalbi_pertemuan2

fun main(){
    //Ranges
    val angkaSatuSepuluh = 1..10
    println("Ada angka 5 kah antara 1-10? : ${5 in angkaSatuSepuluh}")
    println("Ada angka 11 kah antara 1-10? : ${11 in angkaSatuSepuluh}")

    val hurufAZ = 'A'..'Z'
    println("Ada huruf R kah antara A_Z? : ${'R' in hurufAZ}")
    println("Ada huruf ü kah antara A_Z? : ${'ü' in hurufAZ}")

    for (angka in 1..5){
        print(" " + angka)
    }
    println()

    val satuSampeLima = 1.rangeTo(5)
    print("Rangenya 1-5 : ")
    for (x in satuSampeLima){
        print(" " + x)
    }
    println()

    val tujuhKeDua = 7.downTo(2)
    print("Rangenya 7-2 : ")
    for (y in tujuhKeDua){
        print(" " + y)
    }
}