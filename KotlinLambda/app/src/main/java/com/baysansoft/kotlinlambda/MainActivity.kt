package com.baysansoft.kotlinlambda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testString = { myStr: String -> println(myStr) }
        testString("Baysan")

        val mySum = { a: Int, b: Int -> a + b }
        println(mySum(4, 5))

        val myMultiply: (Int, Int) -> Int = { a, b -> a * b }
        println(myMultiply(5,6))
    }
}