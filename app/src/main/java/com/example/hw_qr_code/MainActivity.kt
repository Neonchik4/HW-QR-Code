package com.example.hw_qr_code

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.VolleyError
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.Volley


class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private var imageUrl: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView);
        imageUrl = "https://raw.githubusercontent.com/Neonchik4/HW-QR-Code/refs/heads/master/app/src/main/res/images/qr-code-image.jpg"
        val imageRequest = ImageRequest(
            imageUrl,
            { response: Bitmap ->
                imageView.setImageBitmap(response)
            },
            0,
            0,
            null,
            Bitmap.Config.ARGB_8888,
            { _: VolleyError ->
                Toast.makeText(this@MainActivity, "Изображение не загружено", Toast.LENGTH_SHORT).show()            }
        )
        Volley.newRequestQueue(this).add(imageRequest)
    }
}