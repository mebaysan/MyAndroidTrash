package com.baysansoft.storingdata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    var agePreferences: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // shared preferences INITIALIZE -> küçük verileri kaydedebiliyoruz
        sharedPreferences =
            this.getSharedPreferences("com.baysansoft.storingdata", Context.MODE_PRIVATE)

        agePreferences = sharedPreferences.getInt("customAge", 0)
        if (agePreferences != 0) {
            ageTextView.text = "Your age $agePreferences"
        }
    }

    fun SaveAge(view: View) {


        val age = ageTextBox.text.toString().toIntOrNull()
        if (age != null) {
            ageTextView.text = "Yaşınız: $age"
            sharedPreferences.edit().putInt("customAge", age).apply()
        } else {
            ageTextView.text = "null"
        }
    }

    fun DeleteAge(view: View) {
        agePreferences = sharedPreferences.getInt("customAge", 0)
        if (agePreferences != 0) {
            sharedPreferences.edit().remove("customAge").apply()
            ageTextView.text = "Your age:"
        }

    }
}