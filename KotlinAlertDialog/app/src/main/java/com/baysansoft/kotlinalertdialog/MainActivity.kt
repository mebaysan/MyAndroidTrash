package com.baysansoft.kotlinalertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(applicationContext, "Hoş geldiniz", Toast.LENGTH_LONG).show()
        // 1. parametre hangi context, 2. parametre gözükecek text, 3. parametre ne kadar süre gösterileceği
    }
    /*
                            Context
        Activity Context -> this  / this@ActivityName
        App Context      -> applicationContext
     */

    fun showDialog(view: View) {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Kayıt Ol") // diyalog başlığı
        dialog.setMessage("Emin misin?") // diyalog metni
        dialog.setPositiveButton("Evet") { dialog, which -> // evet/yes buton ekledik ve textini belirledik onclick eventini yazdık
            // On Click Listener
            Toast.makeText(this@MainActivity, "Başarıyla kayıt oldunuz.", Toast.LENGTH_LONG).show()
        }
        dialog.setNegativeButton("Hayır") { dialog, which -> // hayır/no buton ekledik ve textini belirleyip onclick eventini yazdık
            // On Click Listener
            Toast.makeText(this@MainActivity, "Kayıt olamadınız!.", Toast.LENGTH_LONG).show()
        }
        dialog.show()
    }
}