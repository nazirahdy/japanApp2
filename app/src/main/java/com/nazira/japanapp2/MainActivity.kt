package com.nazira.japanapp2

import com.nazira.japanapp2.adapter.DestinationAdapter
import com.nazira.japanapp2.adapter.SightAdapter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nashwa.japanapp.model.Destination
import com.nashwa.japanapp.model.Sight

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // RecyclerView untuk destinasi
        val recyclerViewDestination: RecyclerView = findViewById(R.id.recyclerViewDestination)
        recyclerViewDestination.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val destinationList = listOf(
            Destination("Gunung Fuji", R.drawable.gunungfuji),
            Destination("Kuil Kiyomizu", R.drawable.kuilkiyomizu),
            Destination("Osaka", R.drawable.osaka),
            Destination("tamanueno", R.drawable.tamanueno),
            Destination("Okinawa Aquarium", R.drawable.okinawachuraumiaquarium)
        )
        recyclerViewDestination.adapter = DestinationAdapter(destinationList)

        // RecyclerView untuk sights
        val recyclerViewSight: RecyclerView = findViewById(R.id.recyclerViewSight)
        recyclerViewSight.layoutManager = GridLayoutManager(this, 2)  // 2 kolom
        val sightList = listOf(
            Sight("Sensoji Temple", "Asakusa", R.drawable.image,"Tahun berdiri : 645M" , "Sensoji adalah kuil Buddha tertua dan paling terkenal di Tokyo, terletak di distrik Asakusa. Didirikan pada tahun 645 M, kuil ini merupakan salah satu situs spiritual yang paling dikunjungi di Jepang. Dikenal dengan Gerbang Kaminarimon yang ikonik, kuil ini menarik ribuan pengunjung setiap harinya, baik untuk berdoa maupun untuk menikmati suasana tradisional Jepang. Selain keindahan arsitektur kuil, area sekitarnya, terutama Nakamise-dori, penuh dengan toko-toko yang menjual suvenir khas dan makanan ringan tradisional. Sensoji juga menjadi pusat festival Sanja Matsuri yang terkenal, yang diadakan setiap tahun pada bulan Mei."),
            Sight("Temple", "Tokyo", R.drawable.temple, "Tahun berdiri : 780M","Kiyomizu-dera adalah salah satu kuil paling terkenal di Kyoto, dan dikenal sebagai Situs Warisan Dunia UNESCO. Didirikan pada tahun 780 di sebelah Air Terjun Otowa, kuil ini terkenal dengan pemandangan luar biasa yang dapat dinikmati dari panggung kayu yang berdiri di atas bukit. Nama \"Kiyomizu\" secara harfiah berarti \"air murni\", merujuk pada mata air di dekat kuil. Selain keindahan arsitektur tradisionalnya, kuil ini juga populer selama musim bunga sakura dan musim gugur ketika daun-daun berubah warna. Legenda juga mengatakan bahwa siapa saja yang melompat dari panggung kuil dan bertahan akan mendapatkan keinginan mereka terkabulkan (meskipun praktik ini sekarang dilarang)."),
            Sight("Fushimi Inari Taisha", "Kyoto", R.drawable.image5, "Tahun berdiri : 711M","Fushimi Inari Taisha adalah kuil Shinto utama yang terletak di distrik Fushimi, Kyoto. Didedikasikan untuk Inari, dewa kesuburan, beras, dan perdagangan, kuil ini menjadi salah satu destinasi paling populer di Jepang karena deretan gerbang torii merahnya yang ikonik. Jalur ini membentang hingga ke Gunung Inari, yang dipercaya sebagai tempat suci. Pengunjung dapat berjalan di antara ribuan gerbang torii ini, menikmati ketenangan kuil serta keindahan alam sekitar. Setiap torii didonasikan oleh individu atau perusahaan sebagai bentuk doa untuk keberuntungan. Fushimi Inari juga terkenal dengan patung-patung rubah, yang dianggap sebagai utusan dewa Inari."),
            Sight("osaka ", "Osaka", R.drawable.osaka, "Tahun berdiri: Abad ke 16", "Osaka Castle adalah kastil megah yang dibangun pada akhir abad ke-16 oleh Toyotomi Hideyoshi, seorang daimyo besar Jepang. Kastil ini memainkan peran penting dalam penyatuan Jepang selama Periode Azuchi-Momoyama. Dengan arsitektur khas Jepang yang elegan dan dikelilingi oleh taman luas yang dipenuhi pohon sakura, Osaka Castle menjadi tempat favorit wisatawan, terutama saat musim bunga sakura. Saat ini, kastil ini menjadi museum yang menampilkan sejarah dan budaya Osaka, serta kisah Toyotomi Hideyoshi.")
        )
        recyclerViewSight.adapter = SightAdapter(sightList, this)


    }
}