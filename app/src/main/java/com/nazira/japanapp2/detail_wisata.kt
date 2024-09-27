package com.nazira.japanapp2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class detail_wisata : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_wisata)

        // Ambil data dari intent
        val sightName = intent.getStringExtra("SIGHT_NAME")
        val sightLocation = intent.getStringExtra("SIGHT_LOCATION")
        val sightImage = intent.getIntExtra("SIGHT_IMAGE", 0)
        val sightTanggal = intent.getStringExtra("SIGHT_TANGGAL")
        val sightDescription = intent.getStringExtra("SIGHT_DESCRIPTION")


        // Set data ke tampilan di activity_detail_wisata.xml
        val imageView: ImageView = findViewById(R.id.sightImageDetail)
        val nameTextView: TextView = findViewById(R.id.sightNameDetail)
        val locationTextView: TextView = findViewById(R.id.sightLocationDetail)
        val tanggalTextView: TextView = findViewById(R.id.sightTanggal)
        val descriptionTextView: TextView = findViewById(R.id.sightLocationDeskripsi)


        imageView.setImageResource(sightImage)
        nameTextView.text = sightName
        locationTextView.text = sightLocation
        tanggalTextView.text = sightTanggal
        descriptionTextView.text = sightDescription
    }
}