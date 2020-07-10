package com.baysansoft.classesandfunctions

class Simpson(
    var age: Int?,
    var name: String,
    var job: String
) { // direkt class tanımlarken constructor'ı da tanımlayabiliriz
    private var hair = ""

    fun getHair(): String {
        return this.hair
    }

    fun setHair(_hair: String) {
        this.hair = _hair
    }
    // Property
    /*
    var age: Int
    var name: String
    var job: String

    constructor(_age: Int, _name: String, _job: String) {
        this.age = _age
        this.name = _name
        this.job = _job
    }
     */
}