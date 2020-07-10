package com.baysansoft.kotlinintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_my_custom.*

class MyCustomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_custom)

        //get intent
        val intent = intent
        val username =
            intent.getStringExtra("username") // key-value şeklinde eklediğimiz data'ları intent içerisinden alıyoruz
        val name = intent.getStringExtra("name")

        textName.text = name
        textUsername.text = username
    }
}