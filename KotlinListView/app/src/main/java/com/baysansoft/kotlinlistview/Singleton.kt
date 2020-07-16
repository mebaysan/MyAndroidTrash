package com.baysansoft.kotlinlistview

import android.graphics.Bitmap

class Singleton {
    companion object Selected {
        var selectedImage: Bitmap? = null
    }
}