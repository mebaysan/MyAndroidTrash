package com.baysansoft.kotlinoop

class Student(_name: String, age: Int, _classroom: String) {
    private var name: String? = _name
    private var age: Int? = age
    private var classroom: String? = _classroom

    fun getName(): String? {
        return this.name
    }

    fun setName(_name: String) {
        this.name = _name
        println("Objenin adı $_name olarak güncellendi")
    }

    fun getAge(): Int? {
        return this.age
    }

    fun setAge(_age: Int) {
        this.age = _age
        println("Objenin yaşı $_age olarak güncellendi")
    }

}