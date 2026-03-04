package com.example.bioskopapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bioskopapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFilm1.setOnClickListener { pilihFilm("Avengers: Endgame") }
        binding.btnFilm2.setOnClickListener { pilihFilm("Spider-Man: No Way Home") }
        binding.btnFilm3.setOnClickListener { pilihFilm("The Batman") }
    }

    private fun pilihFilm(namaFilm: String) {
        val intent = Intent(this, ChooseSeatActivity::class.java)
        intent.putExtra("FILM", namaFilm)
        startActivity(intent)
    }
}