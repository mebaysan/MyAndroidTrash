package com.baysansoft.kotlinintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun funLogin(view: View) {
        val intent = Intent(
            applicationContext,
            MyCustomActivity::class.java
        ) // activity'ler arasında geçiş yapabilmemizi sağlar
        startActivity(intent) // belirttiğimiz sınıfa bizi götürecektir
    }
}