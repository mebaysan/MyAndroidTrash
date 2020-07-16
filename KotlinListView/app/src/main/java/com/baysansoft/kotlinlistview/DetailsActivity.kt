package com.baysansoft.kotlinlistview

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.list_row.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val intent = intent
        val landmarkName = intent.getStringExtra("name")
        textView.text = landmarkName

        val landmarkImageId = intent.getIntExtra("image", 0)
        val selectedBitMap =
            BitmapFactory.decodeResource(applicationContext.resources, landmarkImageId)
        imageView.setImageBitmap(selectedBitMap)

//        val singleton = Singleton.Selected
//        val selectedBitMap = singleton.selectedImage
//        imageView.setImageBitmap(selectedBitMap)
    }
}