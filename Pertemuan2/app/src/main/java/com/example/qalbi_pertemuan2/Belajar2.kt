package com.example.qalbi_pertemuan2

fun main(){
    //Array
    val cobaArray = arrayOf("Silahkan", "Tuliskan", "Apa", "Saja")
    println("Data cobaArray Index 0 : [${cobaArray[0]}]")
    println("Data cobaArray Index 3 : [${cobaArray[3]}]")
    println("Isi seluruh cobaArray : ${cobaArray.contentDeepToString()}")
    println("Panjang cobaArray : "+cobaArray.size)
    println("Get cobaArray Index 2 : ${cobaArray.get(2)}")

    val cobaArray2 = arrayOf(1,2,3,4,5)
    println("Data cobaArray Index 2 : [${cobaArray2[2]}]")
    println("Isi seluruh cobaArray : ${cobaArray2.contentDeepToString()}")
    println("Panjang cobaArray : "+cobaArray2.size)

    cobaArray2.set(4,10)
    println("Hasil cobaArray2 Index 4 setelah di Set : ${cobaArray2[4]}")

    val cobaArray3 = arrayOf("Silahkan", "Tuliskan", "Apa", "Saja",1,2,3,4,5)
    println("Isi seluruh cobaArray : ${cobaArray3.contentDeepToString()}")

    println(cobaArray.toString())
}