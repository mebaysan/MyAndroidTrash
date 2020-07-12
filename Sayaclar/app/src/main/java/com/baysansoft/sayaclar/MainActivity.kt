package com.baysansoft.sayaclar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        object :
            CountDownTimer(10000, 1000) { // 10 saniye çalışsın, 1 saniyede bir işlem gerçekleşsin
            override fun onFinish() { // bütün işlem bitince ne olacak
                textView.text = "Kalan: 0"
                Toast.makeText(this@MainActivity, "Sayaç durdu", Toast.LENGTH_LONG).show()
            }

            override fun onTick(millisUntilFinished: Long) { // samiyede bir ne olacak
                textView.text = "Kalan: ${millisUntilFinished / 1000}"
            }

        }.start() // CountdownTimer'ı başlatıyoruz
    }
}