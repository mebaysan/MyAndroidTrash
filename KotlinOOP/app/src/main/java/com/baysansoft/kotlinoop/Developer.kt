package com.baysansoft.kotlinoop

open class Developer(_name: String, _age: Int, _programmingLanguage: String, _osName: String) {
    var name: String? = _name
    var age: Int? = _age
    var programmingLanguage: String? = _programmingLanguage
    var osName: String? = _osName

    fun coding() {
        println("${this.name} developerı ${this.programmingLanguage} ile kodlamaya başladı :)")
    }

    fun refactor() {
        println("Proje refactor ediliyor")
    }

    fun refactor(projeAdi: String) {
        println("$projeAdi refactor ediliyor")
    }

    fun refactor(projeAdi: String, projeAdi2: String) {
        println("$projeAdi ve $projeAdi2 refactor ediliyor")
    }

    open fun develop() {
        println("Developer developing")
    }
}

class WebDeveloper(
    _name: String,
    _age: Int,
    _programmingLanguage: String,
    _osName: String,
    _deploymentArea: String
) :
    Developer(_name, _age, _programmingLanguage, _osName) {
    var deploymentArea: String? = _deploymentArea


    override fun develop() {
        super.develop()
        println("WebDeveloper developing")
    }
}

class MobileDeveloper(
    _name: String,
    _age: Int,
    _programmingLanguage: String,
    _osName: String,
    _marketName: String
) :
    Developer(_name, _age, _programmingLanguage, _osName) {
    var marketName = _marketName
    override fun develop() {
        println("MobileDeveloper developing")
    }
}