package com.baysansoft.kotlinsimplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var NUMBER1: Int? = null
    var NUMBER2: Int? = null
    var RESULT: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickTopla(view: View) {
        NUMBER1 = textNumber1.text.toString().toIntOrNull() // Int'e veya Null'a çevir dedik
        NUMBER2 = textNumber2.text.toString().toIntOrNull()
        if (NUMBER1 == null || NUMBER2 == null) {
            resultText.text = "Error!"
        } else {
            RESULT =
                NUMBER1!! + NUMBER2!! // null kontrolünü geçerse '!!' sayesinde kesinlikle bu değişken null değil dedik
            resultText.text = "Sonuç: ${RESULT}"

        }

    }

    fun clickCikar(view: View) {
        NUMBER1 = textNumber1.text.toString().toIntOrNull()
        NUMBER2 = textNumber2.text.toString().toIntOrNull()
        if (NUMBER1 == null || NUMBER2 == null) {
            resultText.text = "Error!"
        } else {
            RESULT = NUMBER1!! - NUMBER2!!
            resultText.text = "Sonuç: ${RESULT}"

        }
    }

    fun clickCarp(view: View) {
        NUMBER1 = textNumber1.text.toString().toIntOrNull()
        NUMBER2 = textNumber2.text.toString().toIntOrNull()
        if (NUMBER1 == null || NUMBER2 == null) {
            resultText.text = "Error!"
        } else {
            RESULT = NUMBER1!! * NUMBER2!!
            resultText.text = "Sonuç: ${RESULT}"

        }
    }

    fun clickBol(view: View) {
        NUMBER1 = textNumber1.text.toString().toIntOrNull()
        NUMBER2 = textNumber2.text.toString().toIntOrNull()
        if (NUMBER1 == null || NUMBER2 == null) {
            resultText.text = "Error!"
        } else {
            RESULT = NUMBER1!! / NUMBER2!!
            resultText.text = "Sonuç: ${RESULT}"

        }

    }
}

