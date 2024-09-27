package com.nazira.japanapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.nazira.japanapp2.MainActivity
import com.nazira.japanapp2.R
import com.nazira.japanapp2.adapter.ImageAdapter

class SplashActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var titleTextView: TextView
    private lateinit var descriptionTextView: TextView
    private val images = intArrayOf(R.drawable.image, R.drawable.temple, R.drawable.image5, R.drawable.osaka)
    private val titles = arrayOf("Sensoji Temple", "Temple", "Fushimi Inari", "Osaka")
    private val descriptions = arrayOf(
        "Sensoji adalah kuil Buddha tertua dan paling terkenal di Tokyo, terletak di distrik Asakusa.",
        "Kiyomizu-dera adalah salah satu kuil paling terkenal di Kyoto, dan dikenal sebagai Situs Warisan Dunia UNESCO.",
        "Fushimi Inari Taisha adalah kuil Shinto utama yang terletak di distrik Fushimi, Kyoto.",
        "Osaka Castle adalah kastil megah yang dibangun pada akhir abad ke-16 oleh Toyotomi Hideyoshi"
    )
    private val autoSlideDelay = 1500L // Set 3 detik interval untuk auto-slide
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        viewPager = findViewById(R.id.viewPager)
        titleTextView = findViewById(R.id.splasjdl)
        descriptionTextView = findViewById(R.id.descsplas)
        val adapter = ImageAdapter(this, images)
        viewPager.adapter = adapter

        // Auto-slide untuk ViewPager2
        autoSlideImages()

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                // Update teks sesuai dengan gambar yang ditampilkan
                titleTextView.text = titles[position]
                descriptionTextView.text = descriptions[position]
            }
        })

        // Tombol "See Details" ketika diklik
        val buttonDetails: Button = findViewById(R.id.buttonDetails)
        buttonDetails.setOnClickListener {
            // Pindah ke MainActivity
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        // Opsi untuk auto-pindah setelah beberapa detik
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 5000) // Delay 5 detik
    }

    // Fungsi untuk auto-slide ViewPager2
    private fun autoSlideImages() {
        handler = Handler(Looper.getMainLooper())
        runnable = object : Runnable {
            override fun run() {
                val currentItem = viewPager.currentItem
                if (currentItem < images.size - 1) {
                    viewPager.currentItem = currentItem + 1
                } else {
                    viewPager.currentItem = 0
                }
                // Slide setiap 3 detik
                handler.postDelayed(this, autoSlideDelay)
            }
        }
        // Memulai slide otomatis setelah 3 detik
        handler.postDelayed(runnable, autoSlideDelay)
    }

    override fun onDestroy() {
        super.onDestroy()
        // Pastikan handler tidak aktif saat aktivitas dihancurkan
        handler.removeCallbacks(runnable)
    }
}