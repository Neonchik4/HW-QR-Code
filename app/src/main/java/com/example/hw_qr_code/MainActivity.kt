package com.example.hw_qr_code

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy


class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private var imageUrl: String = "https://raw.githubusercontent.com/Neonchik4/HW-QR-Code/refs/heads/master/app/src/main/res/drawable/images/qr-code-image.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        Glide.with(this)
            .asBitmap()
            .load(imageUrl)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imageView)
            .clearOnDetach()
    }
}