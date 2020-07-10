package com.baysansoft.classesandfunctions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import com.baysansoft.classesandfunctions.Simpson

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun makeSimpson(view: View) {
        val name = nameText.text.toString()
        val _age = ageText.text.toString().toIntOrNull()
        var age: Int
        if (_age == null) {
            age = 0

        } else {
            age = _age
        }
        val job = jobText.text.toString()

        val simpson = Simpson(age, name, job)

        resultText.text = "Age -> ${simpson.age} Name -> ${simpson.name} Job -> ${simpson.job}"
    }

}

