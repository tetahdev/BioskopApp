package com.example.bioskopapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvNama = findViewById<TextView>(R.id.tvNama)
        val tvNim = findViewById<TextView>(R.id.tvNim)
        val tvMenu = findViewById<TextView>(R.id.tvMenu)
        val tvHarga = findViewById<TextView>(R.id.tvHarga)

        val etJumlah = findViewById<EditText>(R.id.etJumlah)
        val btnHitung = findViewById<Button>(R.id.btnHitung)
        val tvTotal = findViewById<TextView>(R.id.tvTotal)

        val nama = intent.getStringExtra("nama")
        val nim = intent.getStringExtra("nim")
        val menu = intent.getStringExtra("menu")
        val harga = intent.getIntExtra("harga",0)

        tvNama.text = "Nama : $nama"
        tvNim.text = "NIM : $nim"
        tvMenu.text = "Menu : $menu"
        tvHarga.text = "Harga : $harga"

        btnHitung.setOnClickListener {

            val jumlah = etJumlah.text.toString().toInt()

            val total = jumlah * harga

            tvTotal.text = "Total : $total"

        }

    }

}