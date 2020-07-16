package com.baysansoft.kotlinoop

interface Islem {
    fun topla(a: Int, b: Int)
    fun cikar(a: Int, b: Int)
    fun carp(a: Int, b: Int)
    fun bol(a: Int, b: Int) {
        println("Bolum = ${a / b}")
    }
}

class Matematik : Islem {
    override fun topla(a: Int, b: Int) {
        println("Sonuc = ${a + b}")
    }

    override fun cikar(a: Int, b: Int) {
        println("Sonuc = ${a - b}")

    }

    override fun carp(a: Int, b: Int) {
        println("Sonuc = ${a * b}")

    }

}