package com.example.bioskopapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bioskopapp.databinding.ActivityConfirmationBinding

class ConfirmationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfirmationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val film = intent.getStringExtra("FILM") ?: ""
        val jumlah = intent.getIntExtra("JUMLAH", 0)
        val total = intent.getIntExtra("TOTAL", 0)

        val detail = "Film: $film\nJumlah Tiket: $jumlah\nTotal Dibayar: Rp $total"
        binding.tvDetailKonfirmasi.text = detail

        binding.btnKembali.setOnClickListener {
            val intentHome = Intent(this, MainActivity::class.java)
            intentHome.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intentHome)
            finish()
        }
    }
}