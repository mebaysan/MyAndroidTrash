package com.baysansoft.kotlinintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // bir aktivite *ilk* açılırken bu metot çalışır
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("on create called")

    }

    override fun onResume() { // bir aktivite çalışırken bu metot çalışır
        super.onResume()
        println("on resume called")
    }

    override fun onPause() { // bir aktiviteden başka bir aktiviteye geçiş esnasında bu metot çalışır
        super.onPause()
        println("on pause called")

    }

    override fun onStop() { // bir aktiviteden diğer bir aktiviteye geçildiğinde bu metot çağrılır
        super.onStop()
        println("on stop called")

    }

    override fun onDestroy() { // bir aktivite tamamen kapatıldığında bu metot çağrılır
        super.onDestroy()
        println("on destroy called")

    }

    fun funLogin(view: View) {
        val intent = Intent(
            applicationContext,
            MyCustomActivity::class.java
        ) // activity'ler arasında geçiş yapabilmemizi sağlar
        intent.putExtra(
            "username",
            editTextUsername.text.toString()
        ) // key-value şeklinde bu değerleri Intent içerisine ekliyoruz
        intent.putExtra("name", editTextName.text.toString())
        startActivity(intent) // belirttiğimiz sınıfa bizi götürecektir
        finish() // bu aktiviteyi bitirir/kapatır 
    }
}