package com.baysansoft.kotlinintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MyCustomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_custom)
    }
}