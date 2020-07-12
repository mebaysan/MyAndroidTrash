package com.baysansoft.kennyiyakalamak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var SCORE = 0

    var imageArray = ArrayList<ImageView>()

    var handler = Handler()
    var runnable = Runnable { }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageArray.add(imageView)
        imageArray.add(imageView2)
        imageArray.add(imageView3)
        imageArray.add(imageView5)
        imageArray.add(imageView6)
        imageArray.add(imageView7)
        imageArray.add(imageView8)
        imageArray.add(imageView9)
        imageArray.add(imageView10)
        imageArray.add(imageView11)
        imageArray.add(imageView12)
        imageArray.add(imageView13)

        hideImages()

        object : CountDownTimer(15000, 1000) {
            override fun onFinish() {
                textTime.text = "Zaman: 0"

                handler.removeCallbacks(runnable)
                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }

                val dialog = AlertDialog.Builder(this@MainActivity)
                dialog.setTitle("Oyun Bitti")
                dialog.setMessage("Oyuna yeniden başlamak ister misiniz?")
                dialog.setPositiveButton("Evet") { dialog, which ->
                    val intent = intent
                    finish()
                    startActivity(intent)
                }
                dialog.setNegativeButton("Hayır") { dialog, which ->
                    Toast.makeText(this@MainActivity, "Oyun Bitti", Toast.LENGTH_LONG).show()
                }
                dialog.show()

            }

            override fun onTick(millisUntilFinished: Long) {
                textTime.text = "Zaman: ${millisUntilFinished / 1000}"
            }
        }.start()
    }

    fun increaseScore(view: View) {
        SCORE++
        textScore.text = "Skor: $SCORE"
    }

    fun hideImages() {
        runnable = object : Runnable {
            override fun run() {
                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }
                val randomIndex = Random.nextInt(11)
                imageArray[randomIndex].visibility = View.VISIBLE

                handler.postDelayed(runnable, 500)
            }

        }

        handler.post(runnable)

    }
}