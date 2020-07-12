package com.baysansoft.runnable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var number = 0
    var runnable: Runnable = Runnable { }
    var handler: Handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun start(view: View) {
        number = 0
        runnable = object : Runnable {
            override fun run() {
                number = number + 1
                textView.text = "Zaman: $number"
                handler.postDelayed(this, 1000) // runnable kaç saniyede bir işlemi yapsın
            }
        }
        handler.post(runnable) // runnable'ı çalıştırır
    }

    fun stop(view: View) {
        handler.removeCallbacks(runnable)
        number = 0
        textView.text = "Zaman: $number"
    }
}