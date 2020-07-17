package com.example.udacityaboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.done_button).setOnClickListener { view -> // bu şekilde parametreyi kendimiz isimlendirebiliriz
            // button click dinleyici
            addNickname(view)
        }

    }

    private fun addNickname(view: View) { // b.r view bu fonksiyonu kullanacağı için parametre olarak view alıyoruz
        val editText =
            findViewById<EditText>(R.id.nickname_edit) // nickname_edit id'li view'ı değişkene atadık
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        nicknameTextView.text = editText.text // text'i değiştirdik
        editText.visibility = View.GONE
        view.visibility = View.GONE // bu fonksiyonu kullanan view'ın görünümünü gizledik
        nicknameTextView.visibility =
            View.VISIBLE // görünümü gizli olan nicknameTextView'ın görünümünü açığa çıkardık

        // klavyeyi gizlemek
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}