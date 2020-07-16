package com.baysansoft.kotlinlistview

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var landmarkNames = ArrayList<String>()
        landmarkNames.add("Kız Kulesi")
        landmarkNames.add("Boğaz Köprüsü")
        landmarkNames.add("Ayasofya Camii")

//
//        val kizKulesi = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.kiz)
//        val bogazKoprusu =
//            BitmapFactory.decodeResource(applicationContext.resources, R.drawable.bogaz)
//        val ayasofya =
//            BitmapFactory.decodeResource(applicationContext.resources, R.drawable.ayasofya)
//        var landmarkImages = ArrayList<Bitmap>()
//        landmarkImages.add(kizKulesi)
//        landmarkImages.add(bogazKoprusu)
//        landmarkImages.add(ayasofya)


        val kizId = R.drawable.kiz
        val bogazId = R.drawable.bogaz
        val ayasofyaId = R.drawable.ayasofya

        var landmarkImageIds = ArrayList<Int>()
        landmarkImageIds.add(kizId)
        landmarkImageIds.add(bogazId)
        landmarkImageIds.add(ayasofyaId)


        val adapter =
            ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, landmarkNames)
//        val adapter =
//            ArrayAdapter(this@MainActivity, R.layout.list_row,R.id.textView2 ,landmarkNames)
        listView.adapter = adapter

        listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val intent = Intent(applicationContext, DetailsActivity::class.java)
                intent.putExtra("name", landmarkNames[position])
                intent.putExtra("image", landmarkImageIds[position])
//                val singleton = Singleton.Selected
//                singleton.selectedImage = landmarkImages[position]
                startActivity(intent)
            }

    }
}