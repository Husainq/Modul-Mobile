package com.example.qalbi_pertemuan3
// Exception Handling
fun main(){
    println("Coba Exception Handling 1")
    try{
        val testError = 10/0
        println("Contoh Error")
        println(testError)
    }
    catch (e: ArithmeticException){
        println("ArithmeticException")
    }
    catch (e : Exception){
        println(e)
    }
    finally {
        println("Pada block finally, apapu itu yang terjadi ya tetap di print")
    }
    println("\nCoba Exception Handling 2")
    contohError()
}

fun contohError(){
    try{
        println("Sebelum Exception")
        throw Exception("Hayoooo masalahnya masuk ke Throw")
        println("Sesudah Exception")
    }
    catch (e : Exception){
        println(e)
    }
    finally {
        println("Masih error, tapi finally tetap muncul ya")
    }
}
